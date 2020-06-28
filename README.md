# flutter_bmap
Flutter调用原生（Andriod）百度地图

对于Flutter早有听闻，但是对它从未了解过。悄悄窥视一下，对于 Flutter 组件真是简单又惊艳。官方短视频 https://www.youtube.com/watch?v=b_sQ9bMltGU&list=PLjxrf2q8roU23XGwz3Km7sQZFTdB996iG。而对于Dart编程语言。原本写 C# & JAVA 的人可以说是“所见即所得”。可以马上上手。对于APP混合开发一直是很纠结的选择。正好最近纠结这个事情才真正遇上Flutter。所以决定采用它来开始我的一个项目。决定走上折腾之旅。首先一道坑：
# 地图
基于百度已推出了Flutter插件。不加考虑就选择了它。而插件是没有地图呈现的。只是定位而已。设想方案：用html来展示，通过JS与Flutter交互，达到基本呈现结果。实现之后基本能达到效果。但是体验结果不满意。
将 web版本的百度地图放在服务器上，然后 flutter 通过 webview 载入它。这个方式会受网络质量直接影响呈现效果。于是将 HTML页面放在 assets 中。效果稍微好一点。但是！！发布后，真机不能显示该HTML页面！！原因不明。因为不专业带来的痛苦真是不少，于是暂时放弃了。选择引用原生的方案。本来以为会有很多的实例可参考，甚至是捡来即用的代码。找了一阵得到一些JAVA实现的代码。主要有以下几个文件：
- MainActivity 原来的程序代码
- **ViewFactory 视图工厂 自建
- **Application 程序入口 自建
- **ViewRegistrant 插件注册方法 自建

网上找来的代码跑不起来。原因是那些示例都是基于早期版本的 flutter 实现。我目前的版本是 `Flutter 1.17.4`, `Dart 2.8.4`主要的坑：
- `io.flutter.app.FlutterActivity` 新版本使用了 `io.flutter.embedding.android.FlutterActivity` 注册方法的对象为 `FlutterEngine`
- 地图显示后，重绘就出现黑线。在工厂方法中要有这行代码：
```DART 
override fun dispose() {
    mapView.onResume() <<--- 具体可以查看百度地图API文档的 生命周期
}
```
