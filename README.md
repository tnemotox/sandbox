# sandbox
初学者に向けた勉強会用の題材を仕込んだプロジェクトです。  
以下でサンプルプロジェクトが起動します。

```
# gradle bootRun
```
* h2コンソール 
  * [http://localhost:8080/console](http://localhost:8080/console)
    * JDBC URL: jdbc:h2:file:./testdb/testdb
    * Username: sa
    * Password: (空欄)
* 性能劣化を防ぐためにループからのデータベースアクセスは極力避ける
  * [http://localhost:8080/benchmark/sql/loop](http://localhost:8080/benchmark/sql/loop)
* MyBatisを利用してデータベースからキーを識別子、値をEntityとするMapを取得する
  * [http://localhost:8080/mybatisToMap](http://localhost:8080/mybatisToMap)
