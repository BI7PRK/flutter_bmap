package com.flutterapp.bmap

import com.baidu.mapapi.map.BaiduMap
import com.baidu.mapapi.map.BaiduMapOptions
import com.baidu.mapapi.map.MapView
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugins.GeneratedPluginRegistrant

class MainActivity: FlutterActivity() {
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine);

        var options = BaiduMapOptions()
        options.mapType(BaiduMap.MAP_TYPE_NORMAL) //地图类型

        val mapView = MapView(this, options)
        MapViewRegistrant.registerWith(flutterEngine, mapView)

        super.configureFlutterEngine(flutterEngine)
    }
}
