package com.flutterapp.bmap

import android.content.Context
import android.view.View
import com.baidu.mapapi.map.MapView
import io.flutter.plugin.common.MessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory

class BMapViewFactory (createArgsCodec: MessageCodec<Any?>?, private val mapView: MapView) : PlatformViewFactory(createArgsCodec){
    override fun create(context: Context, i: Int, o: Any?): PlatformView {
        return object : PlatformView {
            override fun getView(): View {
                return mapView
            }

            override fun dispose() {
                mapView.onResume() //避免二次重绘后的黑线问题
            }
        }
    }
}