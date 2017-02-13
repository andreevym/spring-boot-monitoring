# spring-boot-monitoring

Сейчас для нагрузки сайта и мониторинга у меня 3 проекта.
1) Docker InfluxDB + Grafana
2) Spring Boot
3) Скрипт нагрузки для JMeter

Результат: систему мониторинга нашего Spring Boot приложения, которую сможем нагрузить с помощью готового JMeter скрипта
![](grafana.png)

1) Docker InfluxDB + Grafana
https://github.com/andreevym/monitoring

docker InfluxDB - база данных в которой мы будет хранить метрики
http:/localhost:8086

docker Grafana - средство для постоения графиков на основе DataSource (InfluxDB)
в real time собирает метрики и отображет их на графике
http:/localhost:3000

скачали проект запустили init.sh у вас развернулась бд http://localhost:8086 и графана http://localhost:3000

2) Spring Boot - стартуем на 9000 порту сервер и выставляем REST контроллер http://localhost:9000/hello-world
https://github.com/andreevym/spring-boot-monitoring/

при обращение к REST у нас идет запись duration в InfluxDB

3) Скрипт нагрузки для JMeter который нужно открыть.
https://github.com/andreevym/jmeter

как установить JMeter? для этого нам нужно зайти на сайт 

http://jmeter.apache.org/download_jmeter.cgi
скачиваем jmeter !(http://apache-mirror.rbc.ru/pub/apache//jmeter/binaries/apache-jmeter-3.1.zip)
делаем unzip,
в папке bin найдем jmeter.sh
и открываем скрипт приложенный в репозитории
