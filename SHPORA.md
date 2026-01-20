    mvn clean tests  ЧИСТИТ ТЕСТЫ И ЗАПУСКАЕТ ИХ ( МОЖНО В НАЧАЛЕ УДАЛИТЬ ПАПКУ ТАРГЕТ)    

Анатаций :
@Test(enabled = false) // помогает сказать доступен наш тест или нет если false то тест не будет выполняться
@Test(description = "Тест с описанием") // делаем описание и отображается в отчете только

@Test(invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 3)
//3-позволяет распаралелить этот метот, не последовательно а паралельно
public void testSum5() throws InterruptedException {
Thread.sleep(500);
Assert.assertEquals(calculator.sum(2, 3), 5, "Невернная сумма ...");
}

//mvn clean test  - ЗАПУСКАЕТ ВСЕ ТЕСТЫ В ПРОЕКТЕ С АНАТАЦИЕЙ @Test

🔹 assertEquals — сравниваю данные
🔹 assertTrue — проверяю состояние
🔹 assert’ы НЕ пишут в Page Object
🔹 assert’ы живут в Test / Steps

// Assert.   -- очень много методов для проверок
//true -если проверить актуальный результат
//Equals  - сравнить ожидаемый и вактический результат
//Assert.assertEquals(calculator.sum(2, 3), 5, "Невернная сумма ..."); -- коментарий появляется если не прошли проверку

               //Параметры аннотаций (Атрибуты анатаций)

@Test(enabled = false) - атрибут enabled анатаций говорит доступен тест или нет ( тру фолс)

@Test(description = "Тест с описанием") - атрибут  description добовляет описание в репортЕ ( посмотреть: удалить папку таргет
// 1) mvn clean test 2) Открыть таргет 3)Откр surefire - reports 4)index.html 5) Выбрать браузер 6) ПОСЛЕ ПРОСМОТРА УДАЛИТЬ ПАПКУ ТАРГЕТ
@Test(testName = "Тест с названием") - в тест репорте метод переименуется на имя ( отображается в терменале)

@Test(timeOut = 1000) - устанавливает время за которое должен пройти тест Если тест не успел пройти он считается не пройденый  ( измеряется в мили секундах)

Thread.sleep(500); - команда которая затормаживает выполнение на указанные мили секунды

@Test(invocationCount = 3) - выполняет данные тест указанное количество раз

@Test(invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 3) invocationTimeOut - что все 3 теста должны выполниться за указанное время (Они сумируются все 3 в 1)
//threadPoolSize = 3   распоролелить 3 потока
@Test(dependsOnMethods = "stepb") //dependsOnMethods = "stepb"- от какого теста зависит этот и после кого он выполняется , в какой последовательности и если предыдущий падает то этот не выполняется
@Test(dependsOnMethods = "stepa", alwaysRun = true) //alwaysRun - всегда выполнять в независимости от того упал превед тест или нет
@Test(dependsOnMethods = {"stepd", "stepa"}) // ставим{} и указываем от каких методов может зависит от одного или второго
@Test (priority = 1) //priority = 1 -начальное значение 0 у всех
@Test (groups = "smoke") - указываем группу тестов для запуска ее по группам  Так же можно указывать несколько групп
@Test (retryAnalyzer = Retry.class) когда сделан Retry и указываем что тест retryAnalyzer повторяется энное количество раз



@Test (expectedExceptions = NullPointerException.class) //expectedExceptions - ожидаемый результат, если он пришел то тест пройдет
public void exceptionTest() {
List list = null;
int size = list.size();
}

                //Параметризованные тесты

@Test(dataProvider = "dataForSum", dataProviderClass = StaticProvider.class, threadPoolSize = 2) //dataProvider = "dataForSum" - имя дата провайдера. dataProviderClass = StaticProvider.class - указываем класс где содержиться этот метот
public void testSum(int a, int b, int expected) {
Assert.assertEquals(calculator.sum(a, b), expected, "Невернная сумма ...");
}


@Parameters({"Login-value", "psw-value"}) //Это мы указываем в resources файле параметры
@Test
public void paramTest(@Optional("default_user") String Login, //@Optional - позваляет использовать когда отлаживается тест без переданных параметров. Если будет тест через тестнджи то значения будут браться от туда
@Optional("123") String psw) {
System.out.println("Login is:" +Login);
System.out.println("Psw is:" +psw);
}


            CSS Selectors
//<p href=”value”> (p -тег; href- атрибут; value -значение атрибута)
// id - #id (By.cssSelector); - [id='My-Address']  (By.cssSelector); - id (By.id)
// class name - .newsletter (cssSelector)можно множество; - newsletter (className);
// tage name - //h1 (cssSelector и tagName) по селектору именно этот тэг в не текста
// tage name и значению атрибута - div.intro (cssSelector) 1.тэг 2.значение атрибута
// tage name and id - p#my-Address (cssSelector) 1.тэг 2.id
// id и значению атрибута - #Lastname .markup (cssSelector) 1.id пробел 2.значение атрибута
// по двум значения атрибата в иерархий - .intro .markup (cssSelector) в начале родительское значение атрибута потом ниже  значение атрибута
// Поск всех элементов с tagname <h1 OR(логичиское или) <p - h1, p (cssSelector) 1.тэг пробел 2.тэг
// Поиск родительского и подротительского tage - div > p (cssSelector); 1.Родительский tag 2.Подродительский TAG
// Поиск всех элементов с тэгом P которые сразу идут за тэгом ul - ul + p (cssSelector) 1.Тэг плюс 2.подродительский тэг
// Поиск по атрибуду и его значению - [lang='it'] (cssSelector); в начале можно указать тэг p[lang='it']
// Поиск по Тэгу и Атрибуту -  p[lang] (cssSelector) Чисто тэги и атрибут без значение
// Поиск по всем одинаковым Атрибутам и Его значением - [style='overflow: auto;'] (cssSelector); 1.Атрибут 2.Все его значения
// Поиск по ID со часть окончания его значения - [id$='ess'] (cssSelector); 1.ID 2.концовказначения Атрибута
// Поиск по ID с начаниющей частью Атрибута - [id^=L] (cssSelector); 1.ID 2.начало Атрибута