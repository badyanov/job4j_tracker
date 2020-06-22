package ru.job4j.oop;

/**
 * 1.3. Вызов метода с аргументами. [#285766]
 *
 * @author d.badyanov@outlook.com
 */
public class Jukebox {
    private final String firstSong = """
            Пусть бегут неуклюже
            Пешеходы по лужам,
            А вода по асфальту рекой.
            И неясно прохожим
            В этот день непогожий,
            Почему я веселый такой?
            
            А я играю на гармошке
            У прохожих на виду.
            К сожаленью, день рожденья
            Только раз в году.""";

    private final String secondSong = """
            Крыши домов дрожат под тяжестью дней
            Небесный пастух пасёт облака
            Город стреляет в ночь дробью огней
            Но ночь сильней, её власть велика
                
            А тем, кто ложится спать
            Спокойного сна, спокойная ночь
            Тем, кто ложится спать, спокойного сна
            Спокойная ночь""";

    /**
     * @param position должен быть указан 1 или 2
     */
    public void music(int position) {
        String result = "Песня не найдена";
        if (position == 1) {
            result = firstSong;
        } else {
            result = secondSong;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Jukebox aJukebox = new Jukebox();
        System.out.println("Testing for song # 1:");
        aJukebox.music(1);
        System.out.println();
        System.out.println("Testing for song # 2:");
        aJukebox.music(2);
        System.out.println();
        System.out.println("Testing for song # 3:");
        aJukebox.music(3);
    }
}
