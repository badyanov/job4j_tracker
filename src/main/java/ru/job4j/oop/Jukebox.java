package ru.job4j.oop;

/**
 * 1.3. Вызов метода с аргументами. [#285766]
 *
 * @author d.badyanov@outlook.com
 */
public class Jukebox {
    private final String firstSong = "Пусть бегут неуклюже\n"
                                     + "Пешеходы по лужам,\n"
                                     + "А вода по асфальту рекой.\n"
                                     + "И неясно прохожим\n"
                                     + "В этот день непогожий,\n"
                                     + "Почему я веселый такой?\n"
                                     + "\n"
                                     + "А я играю на гармошке\n"
                                     + "У прохожих на виду.\n"
                                     + "К сожаленью, день рожденья\n"
                                     + "Только раз в году.";

    private final String secondSong = "Крыши домов дрожат под тяжестью дней\n"
                                      + "Небесный пастух пасёт облака\n"
                                      + "Город стреляет в ночь дробью огней\n"
                                      + "Но ночь сильней, её власть велика\n"
                                      + "\n"
                                      + "А тем, кто ложится спать\n"
                                      + "Спокойного сна, спокойная ночь\n"
                                      + "Тем, кто ложится спать, спокойного сна\n"
                                      + "Спокойная ночь";

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
