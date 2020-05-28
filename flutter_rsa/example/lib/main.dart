import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:flutter_rsa/flutter_rsa.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _platformVersion = 'Unknown';

  @override
  void initState() {
    super.initState();
    initPlatformState();
  }

  // Platform messages are asynchronous, so we initialize in an async method.
  Future

  <

  void

  >

  initPlatformState

  () async

  {

  Map signMap;
  // Platform messages may fail, so we use a try/catch PlatformException.
  try {
  Map<String, String> map=Map();
  map.putIfAbsent("userId", () => "23231232");
  signMap = await FlutterRsa.getSignMap(map);
  print(signMap.toString()+"flutter");
  } on PlatformException {

  }

  // If the widget was removed from the tree while the asynchronous platform
  // message was in flight, we want to discard the reply rather than calling
  // setState to update our non-existent appearance.
  if (!mounted) return;

  }

  @override
  Widget build(BuildContext context)

  {
  return MaterialApp(
  home: Scaffold(
  appBar: AppBar(
  title: const Text('Plugin example app'),
  ),
  body: Column(
  mainAxisSize: MainAxisSize.max,
  children: <Widget>[
  Image.asset("images/log.png"),
  Image.asset("images/cc.png")
  ],
  )));
  }
}
