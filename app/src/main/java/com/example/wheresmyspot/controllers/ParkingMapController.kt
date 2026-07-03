package com.example.wheresmyspot.controllers

import android.R.attr.padding
import com.example.wheresmyspot.data.constants.MapStyle
import com.example.wheresmyspot.data.dataclasses.ParkingLotDetails
import org.maplibre.android.camera.CameraUpdateFactory
import org.maplibre.android.geometry.LatLng
import org.maplibre.android.geometry.LatLngBounds
import org.maplibre.android.maps.MapLibreMap

class ParkingMapController (
    private val map: MapLibreMap
) {
    val DEFAULT_ZOOM = 13.0

    //Camera
    fun animateCamera(target: LatLng, zoom: Double = 13.0) {
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

    fun fitBounds(bounds: LatLngBounds) {
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
    fun setStyle(
        style: MapStyle,
        onComplete: () -> Unit = {}
    ) {
        map.setStyle(style.styleUrl) {
            onComplete()
        }
    }

    //Parking Markers
    fun showParkingSpots(spots: ParkingLotDetails) {

    }

    fun updateParkingSpot(spot: ParkingLotDetails) {

    }

    fun removeParkingSpot(id: Long) {

    }

    fun clearParkingSpots() {

    }

    fun highlightParkingSpot(id: Long) {

    }

    //User Location
    fun showUserLocation(location: LatLng) {

    }

    fun followUser() {

    }

    fun stopFollowingUser() {

    }

    //Routes
    fun drawRoute() {

    }

    fun clearRoute() {

    }

    //Gestures
    fun enableGestures() {

    }

    fun disableGestures() {

    }

    fun enableRotation() {

    }

    fun enableTilt() {

    }

    //UI Controls
    fun showCompass() {

    }

    fun showScaleBar() {

    }

    fun showLogo() {

    }

    fun showAttribution() {

    }

    //Layers and Overlays
    fun showAvailabilityOverlay() {

    }

    fun hideAvailabilityOverlay() {

    }

    fun showTraffic() {

    }

    fun hideTraffic() {

    }

    fun showHeatmap() {

    }
}