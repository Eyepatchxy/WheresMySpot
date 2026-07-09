package com.example.wheresmyspot.controllers

import android.content.Context
import android.graphics.RectF
import android.util.Log
import com.example.wheresmyspot.R
import com.example.wheresmyspot.data.constants.DEFAULT_MAP_PADDING
import com.example.wheresmyspot.data.constants.DEFAULT_ZOOM
import com.example.wheresmyspot.data.constants.MapStyle
import com.example.wheresmyspot.data.dataclasses.ParkingLotDetails
import com.example.wheresmyspot.data.utils.vectorToBitmap
import com.example.wheresmyspot.map.GeoJsonBuilder
import org.maplibre.android.camera.CameraUpdateFactory
import org.maplibre.android.geometry.LatLng
import org.maplibre.android.geometry.LatLngBounds
import org.maplibre.android.maps.MapLibreMap
import org.maplibre.android.style.layers.CircleLayer
import org.maplibre.android.style.layers.PropertyFactory.circleColor
import org.maplibre.android.style.layers.PropertyFactory.circleRadius
import org.maplibre.android.style.layers.PropertyFactory.circleStrokeColor
import org.maplibre.android.style.layers.PropertyFactory.circleStrokeWidth
import org.maplibre.android.style.layers.PropertyFactory.iconImage
import org.maplibre.android.style.layers.PropertyFactory.iconSize
import org.maplibre.android.style.layers.SymbolLayer
import org.maplibre.android.style.sources.GeoJsonSource
import org.maplibre.geojson.Feature
import org.maplibre.geojson.FeatureCollection

class ParkingMapController (
    private val map: MapLibreMap,
    private val context: Context,
    private val geoJsonBuilder: GeoJsonBuilder = GeoJsonBuilder()
) {
    private companion object {
        const val USER_SOURCE_ID = "user-source"
        const val USER_LAYER_ID = "user-layer"

        const val PARKING_SOURCE_ID = "parking-source"
        const val PARKING_LAYER_ID = "parking-layer"
    }
    private lateinit var userSource: GeoJsonSource
    private lateinit var parkingSource: GeoJsonSource


    //Marker Rendering
    fun initializeUserRendering(location: LatLng) {
        userSource = GeoJsonSource(
            id = USER_SOURCE_ID,
            feature = geoJsonBuilder.buildUserLocation( location )
        )

        val userLayer = CircleLayer(
            USER_LAYER_ID,
            USER_SOURCE_ID
        )

        userLayer.setProperties(
            circleRadius(8f),
            circleColor("#1976D2"),
            circleStrokeWidth(2f),
            circleStrokeColor("#FFFFFF")
        )

        map.style?.addSource(userSource)
        map.style?.addLayer(userLayer)
    }

    fun initializeParkingRendering() {
        parkingSource = GeoJsonSource(
            id = PARKING_SOURCE_ID,
            features = FeatureCollection.fromFeatures(emptyArray())
        )

        val parkingLayer = SymbolLayer(
            PARKING_LAYER_ID,
            PARKING_SOURCE_ID
        )

        val bitmap = vectorToBitmap(context, R.drawable.ic_destination_pin)

        map.style?.addImage(
            "ic_pin",
            bitmap
        )

        parkingLayer.setProperties(
            iconImage("ic_pin"),
            iconSize(0.04f)
        )

        map.style?.addSource(parkingSource)
        map.style?.addLayer(parkingLayer)
    }

    fun showParkingSpots(spots: List<ParkingLotDetails>) {
        parkingSource.setGeoJson(geoJsonBuilder.buildParking(spots))
    }

    fun clearParkingSpots() {
        parkingSource.setGeoJson(geoJsonBuilder.buildParking(emptyList()))
    }


    //Camera
    fun animateCamera(target: LatLng, zoom: Double = DEFAULT_ZOOM) {
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(
                latLng = target,
                zoom = zoom
                )
            )

    }

    fun moveCamera(target: LatLng, zoom: Double) {
        map.moveCamera(
            CameraUpdateFactory.newLatLngZoom(
                latLng = target,
                zoom = zoom
                )
            )
    }

    fun zoomIn(difference: Int = 1) {
        val newZoom = map.zoom + difference
        map.animateCamera(
            CameraUpdateFactory.zoomTo(newZoom)
        )
    }

    fun zoomOut(difference: Int = 1) {
        val newZoom = map.zoom - difference
        map.animateCamera(
            CameraUpdateFactory.zoomTo(newZoom)
        )
    }

    fun setZoom(zoom: Int) {
        map.animateCamera(
            CameraUpdateFactory.zoomTo(zoom.toDouble())
        )
    }

    fun fitBounds( bounds: LatLngBounds, padding: Int = DEFAULT_MAP_PADDING) {
        map.animateCamera(
            CameraUpdateFactory.newLatLngBounds(bounds, padding)
        )
    }

    fun resetNorth() {
        map.resetNorth()
    }

    fun resetCamera(location: LatLng) {
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(location, DEFAULT_ZOOM)
        )
        resetNorth()
    }


    //Style
    fun initializeStyle(style: MapStyle, userLocation: LatLng, onComplete: () -> Unit = {} ) {
        map.setStyle(style.styleUrl) {
            initializeUserRendering(userLocation)
            initializeParkingRendering()
            onComplete()
        }
    }


    //User Location
    fun centerOnUser(location: LatLng) {
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(
                location, DEFAULT_ZOOM
            )
        )
    }

    fun showUserLocation(location: LatLng) {
        userSource.setGeoJson(
            geoJsonBuilder.buildUserLocation(location)
        )
    }

    fun followUser() {
        TODO()
    }

    fun stopFollowingUser() {
        TODO()
    }


    //Routes
    fun drawRoute() {
        TODO()
    }

    fun clearRoute() {
        TODO()
    }


    //Interactions
    fun onMapClick(listener: (LatLng) -> Unit) {
        TODO()
    }

    fun setOnParkingSpotClick(listener: (Long?) -> Unit) {

        map.addOnMapClickListener { latLng ->

            val screenPoint = map.projection.toScreenLocation(latLng)

            val rect = RectF(
                screenPoint.x - 15f,   // left
                screenPoint.y - 25f,   // top (higher)
                screenPoint.x + 15f,   // right
                screenPoint.y + 5f     // bottom (slightly lower)
            )

            val feature = map.queryRenderedFeatures(rect, PARKING_LAYER_ID)
                .firstOrNull()

            if (feature != null) {
                val lotId = feature?.getNumberProperty("lotId")?.toLong()

                listener(lotId)
            }

            true
        }
    }
}