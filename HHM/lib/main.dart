import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

class HttpRequestWidget extends StatelessWidget {
  final String url = 'http://localhost:8080/store/HookahMafia/product/ws';

  Future<void> sendRequest() async {
    try {
      final response = await http.get(Uri.parse(url));

      if (response.statusCode == 200) {
        print('Запрос успешно отправлен');
      } else {
        print('Ошибка при отправке запроса. Код ответа: ${response.statusCode}');
      }
    } catch (e) {
      print('Ошибка при отправке запроса: $e');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('HTTP Запрос'),
      ),
      body: Center(
        child: ElevatedButton(
          onPressed: () {
            sendRequest();
          },
          child: Text('Отправить запрос'),
        ),
      ),
    );
  }
}

void main() {
  runApp(MaterialApp(
    home: HttpRequestWidget(),
  ));
}