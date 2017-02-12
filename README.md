# spring-boot-monitoring

Сейчас для нагрузки сайта и моинторинга у меня 3 проекта.

1) Docker InfluxDB + Grafana
https://github.com/andreevym/monitoring

docker InfluxDB - база данных в которой мы будет хранить метрики
docker Grafana - средство для постоения графиков на основе DataSource (InfluxDB)
в real time собирает метрики и отображет их на графике

скачали проект запустили init.sh у вас развернулась бд http://localhost:9000 и графана http://localhost:3000

2) Spring Boot - стартуем на 9000 порту сервер и выставляем REST контроллер http://localhost:9000/hello-world
https://github.com/andreevym/spring-boot-monitoring/

при обращение к REST у нас идет запись duration в InfluxDB

3) Скрипт нагрузки для JMeter который нужно открыть.
как установить JMeter? для этого нам нужно зайти на сайт 

http://jmeter.apache.org/download_jmeter.cgi
скачиваем jmeter !(http://apache-mirror.rbc.ru/pub/apache//jmeter/binaries/apache-jmeter-3.1.zip)
делаем unzip,
в папке bin найдем jmeter.sh
и открываем скрипт приложенный в репозитории
