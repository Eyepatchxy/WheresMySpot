package com.example.wheresmyspot.controllers

import com.example.wheresmyspot.data.constants.DEFAULT_MAP_PADDING
import com.example.wheresmyspot.data.constants.DEFAULT_ZOOM
import com.example.wheresmyspot.data.constants.MapStyle
import com.example.wheresmyspot.data.dataclasses.ParkingLotDetails
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
import org.maplibre.android.style.sources.GeoJsonSource
import org.maplibre.geojson.FeatureCollection

class ParkingMapController (
    private val map: MapLibreMap,
    private val geoJsonBuilder: GeoJsonBuilder = GeoJsonBuilder()
) {
    private companion object {
        const val PARKING_SOURCE_ID = "parking-source"
        const val PARKING_LAYER_ID = "parking-layer"
    }

    private lateinit var parkingSource: GeoJsonSource


    //Marker Rendering
    fun initializeParkingRendering() {
        parkingSource = GeoJsonSource(
            id = PARKING_SOURCE_ID,
            features = FeatureCollection.fromFeatures(emptyArray())
        )

        val parkingLayer = CircleLayer(
            PARKING_LAYER_ID,
            PARKING_SOURCE_ID
        )

        parkingLayer.setProperties(
            circleRadius(8f),
            circleColor("#1976D2"),
            circleStrokeWidth(2f),
            circleStrokeColor("#FFFFFF")
        )

        map.style?.addSource(parkingSource)
        map.style?.addLayer(parkingLayer)
    }

    fun showParkingSpots(spots: List<ParkingLotDetails>) {
        parkingSource.setGeoJson(geoJsonBuilder.build(spots))
    }

    fun clearParkingSpots() {
        parkingSource.setGeoJson(geoJsonBuilder.build(emptyList()))
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
    fun setStyle( style: MapStyle, onComplete: () -> Unit = {} ) {
        map.setStyle(style.styleUrl) {
            initializeParkingRendering()
            onComplete()
        }
    }


    //User Location
    fun showUserLocation(location: LatLng) {
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(
                location, DEFAULT_ZOOM
            )
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

    fun onParkingSpotClick(listener: (Long) -> Unit) {
        TODO()
    }
}