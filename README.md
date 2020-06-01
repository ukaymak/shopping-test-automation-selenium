Intellij IDEA

Java JDK 13

Maven 3.6.3

Selenium 3.141.59

Testng

chrome driver 83

geckodriver v0.26.0
 
chrome browser 83 versionu kullanilmasi onerilir.

***

Driverlar src > main > resources > drivers klasorunun altindadir.

Projede kullanilan diğer kutuphanelere pom.xml icerinden ulasabilirsiniz.

Projemizi localinize cektikten sonra maven ile dependecyleri import ediyoruz.

Daha sonra calistirmak istedigimiz senaryonun (src > test > java > ShoppingTest) uzerine gelip sag click run diyerek calistiriyoruz.

Screenshot ile ilgili kod kismi Testlistener classinin icerisinde onFailure metodu kisminda yer almaktadır.

Senaryomuz fail ettiginde ekran goruntulerini target klasorune basmaktadir.

Api testi için basit bir adim eklenmistir. 
src > test > ShoppingTest classi icerisinde @Test(priority=0) adiminda sorgu atip 200 kontrolu yapilmaktadir.

Diger adimlar UI testi ile ilgili adimlardir.

datafile.properties file inda test datalari tutulmaktadir.

Browser ayarlari DriverSettings classinda yer almaktadır.Firefox ve Chrome icin calisabilmektedir.

Her calistirdiginizda email bilgisini değiştirmeyi unutmayin.