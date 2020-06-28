package com.flutterapp.bmap

import com.baidu.mapapi.CoordType
import com.baidu.mapapi.SDKInitializer
import io.flutter.app.FlutterApplication
import io.flutter.view.FlutterMain

class RedefiningApplication : FlutterApplication() {
    override fun onCreate() {
        super.onCreate()

        FlutterMain.startInitialization(this);

        // 初始化百度地图 SDK
        SDKInitializer.initialize(this)
        SDKInitializer.setCoordType(CoordType.BD09LL)

    }
}