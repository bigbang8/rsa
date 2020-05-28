import 'dart:async';

import 'package:flutter/services.dart';

class FlutterRsa {
  static const MethodChannel _channel =
      const MethodChannel('flutter_rsa');

  static Future<Map>  getSignMap(Map<String,String> data) async {
    final Map  map=await _channel.invokeMethod('getSignMap',data);
    return map;
  }
}
