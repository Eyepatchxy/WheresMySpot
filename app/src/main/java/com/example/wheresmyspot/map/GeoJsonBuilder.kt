package com.example.wheresmyspot.map

import com.example.wheresmyspot.data.dataclasses.ParkingLotDetails
import com.example.wheresmyspot.data.utils.toJsonArray
import org.maplibre.android.geometry.LatLng
import org.maplibre.geojson.Feature
import org.maplibre.geojson.FeatureCollection
import org.maplibre.geojson.Point

class GeoJsonBuilder {

    fun buildParking(parkingLots: List<ParkingLotDetails> ): FeatureCollection {
        val features = parkingLots.map { parkingLot ->
            buildFeature(parkingLot)
        }

        return FeatureCollection.fromFeatures(features)
    }

    private fun buildFeature( parkingLot: ParkingLotDetails): Feature {
        val feature = Feature.fromGeometry(
            Point.fromLngLat(
                parkingLot.longitude,
                parkingLot.latitude
            )
        )

        feature.addNumberProperty("lotId", parkingLot.lotId)
        feature.addStringProperty("name", parkingLot.name)
        feature.addNumberProperty("availableSpaces", parkingLot.availableSpaces)
        feature.addNumberProperty("totalSpaces", parkingLot.totalSpaces)
        feature.addNumberProperty("hourlyRate", parkingLot.hourlyRate)
        feature.addNumberProperty("rating", parkingLot.rating)
        feature.addProperty("vehicleTypes", toJsonArray(parkingLot.vehicleTypes))

        return feature
    }

    fun buildUserLocation( location: LatLng ): Feature {
        val feature = Feature.fromGeometry(
            Point.fromLngLat(
                location.longitude,
                location.latitude
            )
        )

        return feature
    }
}