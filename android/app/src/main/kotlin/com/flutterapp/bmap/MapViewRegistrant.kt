package com.flutterapp.bmap

import com.baidu.mapapi.map.MapView
import io.flutter.Log
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.StandardMessageCodec

class MapViewRegistrant {
    companion object {
        @JvmStatic
        fun registerWith(flutterEngine: FlutterEngine, mapView: MapView) {
            try {
                val registrar = flutterEngine.platformViewsController.registry
                val view = BMapViewFactory(StandardMessageCodec(), mapView)
                registrar.registerViewFactory("MapView.Baidu", view)
                Log.d("BMapView", "注册完毕")
            } catch (ex: Exception) {
                Log.e("BMapView", "BMapView 注册失败。${ex.message}")
            }
        }
    }
}