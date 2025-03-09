package ar.unrn.testing;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Participante p1 = new Participante(1, "pedro");
        Participante p2 = new Participante(1, "lucas");

        System.out.println(LocalDate.now().isAfter(LocalDate.now()));
    }
}