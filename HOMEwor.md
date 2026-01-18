


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

    4 урок Анатаций и TestNG продолжение 3 урока 
https://t.me/c/1786276747/344 ссылку на сообщение в тг
https://habr.com/ru/company/otus/blog/450872/

1) Реализовать два метода div(int a, int b) and div(double a, double b) в классе Calculator
2) Написать тесты на валидацию данных методов с использованием всех изученных атрибутов
   Обязательно проверить деление на 0


    5 урок  Селениум веб драйвер продолжаем в лессон 4 
https://t.me/c/1786276747/374
https://clinic-cvetkov.ru/company/kalkulyator-imt/ - ссылка из видео где делаем первый тест на уроке 

Написать следующие тесты по сценариям ниже:

Открыть сайт https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx
Ввести параметры для расчета
Нажать на кнопку ‘Рассчитать’
Проверить корректность вычислений
Закрыть окно браузера


Со звездочкой
Открыть сайт https://calc.by/building-calculators/laminate.html
Выбрать ‘Способ укладки ламината’ из выпадающего списка
Ввести ‘Длина комнаты’ = 500
Ввести ‘Ширина комнаты’ = 400
Ввести ‘Длина панели ламината’ = 2000
Ввести ‘Ширина панели ламината’ = 200
Выбрать ’Направление укладки’ = по ширине комнаты
Нажать на кнопку ‘Рассчитать’
Проверить результаты: ‘Требуемое количество досок ламината: 53’
Проверить результаты: ‘Количество упаковок ламината: 7’
Закрыть окно браузера

    6 урок продолжаем локаторы CSS and XPath
https://t.me/c/1786276747/426

Создать отдельный тестовый Java-класс Task_8 с тестом, сценарий:
Залогиниться https://www.saucedemo.com/
Добавить товар в корзину
Перейти в корзину
Проверить (assertEquals) стоимость товара и его имя в корзине
Выполнить поиск локаторов по следующим критериям (тест должен включать хотя  бы один локатор из списка и из подсписка):       
id
name
classname
tagname
linktext
partiallinktext
xpath
Поиск по атрибуту, например By.xpath("//tag[@attribute='value']");
Поиск по тексту, например By.xpath("//tag[text()='text']");
Поиск по частичному совпадению атрибута, например By.xpath("//tag[contains(@attribute,'text')]");
Поиск по частичному совпадению текста, например By.xpath("//tag[contains(text(),'text')]");
ancestor, например //*[text()='Enterprise Testing']//ancestor::div
descendant
following
parent
preceding
*поиск элемента с условием AND, например //input[@class='_2zrpKA _1dBPDZ' and @type='text']
(Подсказка:  XPath Axes)
css
.class
.class1.class2
.class1 .class2
#id
tagname
tagname.class
[attribute=value]
[attribute~=value]
[attribute|=value]
[attribute^=value]
[attribute$=value]
[attribute*=value]
(Подсказка: https://www.w3schools.com/cssref/css_selectors.asp)


    7 урок  пэйдж обжект 
https://t.me/c/1786276747/506

домашка:
1 Написать тест сценарий на один позитивный E2E тест для приложения https://www.saucedemo.com и разместить его в своем файле README.md в корне проекта
2 Реализовать данный тест с использованием PageObject и Steps.
1. Авторизация (Login)
   1.1. Ввести standard_user в поле Username.
   1.2. Ввести secret_sauce в поле Password.
   1.3. Нажать кнопку Login.
2. Добавление товаров (Add product)
   2.1. Нажать Add to cart у первого товара (Sauce Labs Backpack).
   2.2. Кликнуть на название второго товара (Sauce Labs Bike Light) для перехода в карточку.
   2.3. В карточке нажать Add to cart.
   2.4. Нажать Back to products.
   2.5. Нажать Add to cart у третьего товара (Sauce Labs Bolt T-Shirt).
   2.6. Перейти в карточку третьего товара.
   2.7. Нажать Remove (удалить третий товар).
   2.8. Нажать Back to products.
   2.9. Нажать на иконку Корзины в верхнем правом углу.
3. Работа с корзиной (Work with cart)
   3.1. Проверить наличие Sauce Labs Backpack.
   3.2. Проверить наличие Sauce Labs Bike Light.
   3.3. Нажать Remove у Sauce Labs Bike Light.
   3.4. Нажать Continue Shopping.
   3.5. Снова добавить Sauce Labs Bike Light в корзину.
   3.6. Вернуться в корзину.
   3.7. Убедиться, что Sauce Labs Backpack на месте.
   3.8. Убедиться, что Sauce Labs Bike Light на месте.
   3.9. Нажать Checkout.
4. Оформление: Информация (Checkout: Your Information)
   4.1. Ввести любое имя в First Name.
   4.2. Ввести любую фамилию в Last Name.
   4.3. Ввести почтовый индекс в Zip/Postal Code.
   4.4. Нажать Continue.
5. Оформление: Обзор (Checkout: Overview)
   5.1. Сверить наличие первого товара.
   5.2. Сверить наличие второго товара.
   5.3. Проверить, что Item total равен сумме цен двух товаров ($29.99 + $9.99 = $39.98).
   5.4. Проверить итоговое значение Total (с учетом налога).
   5.5. Нажать Finish.
6. Завершение заказа (Checkout: Complete!)
   6.1. Проверить наличие заголовка "Thank you for your order!".
   6.2. Нажать Back Home.
   6.3. Убедиться, что произошел переход на страницу каталога (/inventory.html).
7. Выход (Logout)
   7.1. Открыть боковое меню (бургер-кнопка слева).
   7.2. Нажать Logout.
   7.3. Убедиться, что открыта страница логина.

  1 час 
      8 урок Ожидания явные и не явные 
https://t.me/c/1786276747/524
http://the-internet.herokuapp.com САЙТ ГДЕ можно потренироваться. Есть список разных вариантов 
на уроке нам понадобился http://the-internet.herokuapp.com/dynamic_loading/1  практика WaitsTest класс 
Повторить все что связанно со строками :
1) тримы
2) собстринг
3) реплейс
4) сплиты
5) что такое вообще стринг 
6) что такое стринг форматор
6) что такое странг билдер
7) как вывести строку задом наоборо ( стринг реверс не интересно надо по другому)







