


    3 урок Анатаций и TestNG (Домашки тут нет )
 TestNG нейки фрейморк который помогает запускать тесты 
 Анатаций это нейкий этапом подготовки к выполнению теста 
https://mvnrepository.com/repos/central тут есть все зависимости для maven
https://maven.apache.org/download.cgi - Binary zip archive для установки maven
https://t.me/c/1786276747/313 ссылку на сообщение в тг
добавляем в pom:

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
<modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>aqa_Final</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <aspectj.version>1.8.10</aspectj.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.6.1</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.20</version>
                <configuration>
                    <argLine>
                        -javaagent:"${settings.localRepository}/org/aspectj/aspectjweaver/${aspectj.version}/aspectjweaver-${aspectj.version}.jar"
                    </argLine>

                </configuration>
                <dependencies>
                    <dependency>
                        <groupId>org.aspectj</groupId>
                        <artifactId>aspectjweaver</artifactId>
                        <version>${aspectj.version}</version>
                    </dependency>
                </dependencies>
            </plugin>
        </plugins>
    </build>
</project>

    4 урок Анатаций и TestNG продолжение 3 урока  И начало 4 SeleniumWeb driver
https://t.me/c/1786276747/344 ссылку на сообщение в тг
https://habr.com/ru/company/otus/blog/450872/

  рассказывает как скидывать домашку 1.40 

1) Реализовать два метода div(int a, int b) and div(double a, double b) в классе Calculator
2) Написать тесты на валидацию данных методов с использованием всех изученных атрибутов
   Обязательно проверить деление на 0




