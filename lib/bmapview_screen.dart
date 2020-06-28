import 'package:flutter/material.dart';

class BmapviewScreen extends StatelessWidget {
  BmapviewScreen();

  @override
  Widget build(BuildContext context) {
    return Expanded(
        child: new AndroidView(
      viewType: 'MapView.Baidu',
      onPlatformViewCreated: (id) {
        print('onPlatformViewCreated: $id');
      },
      //creationParamsCodec: const StandardMessageCodec(),
    ));
  }
}
