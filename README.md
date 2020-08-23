Apa itu Spring Framework?
Spring framework adalah sebuah framework atau kerangka kerja yang bersifat open-source. Spring framework sendiri pertama kali dibuat oleh Rod Johnson tahun 2002 sebagai alternatif dari Java Enterprise Edition yang bertujuan untuk mengatasi masalah desain sistem dalam pengembangan aplikasi enterprise. Selain itu, Spring juga mengimplementasikan beberapa teknologi IoC (Inversion of Control) dan DI (Dependency Injection) ke dalam sebuah MVC (Model View Controller). Spring juga menggunakan konsep AOP (Aspect Oriented Programming) untuk memecah logika dari kode menjadi beberapa bagian (disebut concerns) untuk menjalankan pengembangan aplikasi yang terpadu. Berikut adalah konsep penting spring framework:

DI (Injeksi Ketergantungan): komposisi pola desain struktural, dimana untuk setiap fungsi aplikasi ada satu, objek independen bersyarat (service) yang dapat memiliki kebutuhan untuk menggunakan objek lain (dependensi) yang diketahui oleh interface. Dependensi ditransfer(diimplementasikan) ke service pada saat pembuatannya. Ini adalah situasi dimana kami memperkenalkan elemen dari satu kelas ke kelas lainnya. Dalam prakteknya, DI diimplementasikan dengan melewatkan parameter ke konstruktor atau menggunakan setter. Library yang menerapkan pendekatan ini juga disebut kontainer IoC.
Container IOC (Inversion of Control): Prinsip pemrograman berorientasi objek, dimana objek program tidak bergantung pada implementasi konkret objek lain, tetapi mungkin memiliki pengetahuan tentang abstraksi (interface) untuk interaksi selanjutnya.
AOP (Pemrograman Berorientasi Aspek): Paradigma pemrograman yang memungkinkan Anda membedakan fungsionalitas(fungsional) dalam aplikasi. Fungsi-fungsi ini, yang menjangkau banyak node aplikasi, disebut masalah lintas sektoral dan catatan lintas sektoral ini dipisahkan dari logika bisnis langsung aplikasi. Dalam OOP, unit kuncinya adalah kelas, sedangkan di AOP, elemen kuncinya adalah aspek. DI membantu memisahkan kelas aplikasi ke dalam modul terpisah, dan AOP membantu memisahkan masalah lintas sektoral dari objek yang terpengaruh. Contohnya adalah Manajemen transaksi, logging dll.
Apa itu bean di Spring framework?
Bean adalah objek yang dibuat, dirancang, dan dikelola oleh container Spring IoC. Bean ini dibuat dengan metadata konfigurasi yang Anda berikan ke container, misalnya, dalam bentuk definisi XML atau Anotasi.

Program pertama Spring Framework
Kami akan memberikan contoh langkah demi langkah cepat dengan penjelasan singkat untuk mendemonstrasikan bagaimana implementasi tertentu dari sebuah interface dapat dimasukkan ke aplikasi klien menggunakan Spring Framework.

Dependensi dan Teknologi yang digunakan:

Spring Context
JDK 8
Maven 3.5.4
Untuk contoh lengkapnya silakan kunjungi github kami.

Membuat interface dengan satu method dengan parameter tipe String:


public interface HelloWorldService {
    void sayHello(String name);
}

Membuat kelas yang mengimplementasikan interface HelloWorldService:


public class HelloWorldServiceImpl implements HelloWorldService {

    public void sayHello(String message) {
        System.out.println(message);
    }
}

Membuat kelas client dan memanggil HelloWorldService:


public class HelloWorldServiceClient {

    @Autowired
    private HelloWorldService helloWorld;

    public void showMessage() {
        helloWorld.sayHello("Hello world!");
    }
}

Apa itu @Autowired?
Dalam kode di atas, kami menggunakan anotasi @Autowired di kelas HelloWorldServiceClient. Anotasi ini memberi tahu container Spring tempat melakukan dependensi injeksi. Kita harus mendaftarkan instance HelloWorldServiceClient sebagai bean untuk mewujudkannya. Kami juga harus mendaftarkan HelloWorldServiceImpl sebagai bean. Selanjutnya kita akan melihat bagaimana kita dapat melakukannya dengan menggunakan @Configuration pada kelas konfigurasi Java.

Konfigurasi Spring Container
Dalam contoh ini, class App, bertanggung jawab untuk mendepinisikan dan membuat dependensi. Dengan kata lain, ini adalah kelas konfigurasi khusus Spring. Kami menunjukkan Konfigurasi berbasis Java yang merupakan alternatif dari konfigurasi berbasis XML. Kelas yang sama juga bertanggung jawab untuk memulai container Spring dari method main.


@Configuration
public class App {

   @Bean
    public HelloWorldService createHelloWorldService() {
   }

   @Bean
   public HelloWorldServiceClient createClient() {
       return new HelloWorldServiceClient();
   }

   public static void main(String[] strings) {
       AnnotationConfigApplicationContext context =
                               new AnnotationConfigApplicationContext(AppRunner.class);
       HelloWorldServiceClient bean = context.getBean(HelloWorldServiceClient.class);
       bean.showMessage();
   }

}
