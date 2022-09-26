package com.example.demo;

import com.example.demo.negocio.Comprimento;

class App {
  public static void main(String[] args) {
    System.out.println("Olá mundo!");

		Time zero = new Time();
		// representação string, padrão 00:00:00
		System.out.println(zero); // 00:00:00
		System.out.println(zero.toString().equals("00:00:00"));

		Time umaHoraQuarentaMinCincoSeg = new Time(1, 40, 5);
		System.out.println(umaHoraQuarentaMinCincoSeg); // 01:40:05
		System.out.println(umaHoraQuarentaMinCincoSeg.toString().equals("01:40:05"));

		Time umaHoraQuarentaMinutosCincoSegundos = zero.plus(umaHoraQuarentaMinCincoSeg);
		System.out.println(umaHoraQuarentaMinutosCincoSegundos); // 01:40:05
		System.out.println(umaHoraQuarentaMinutosCincoSegundos.toString().equals("01:40:05"));
		System.out.println(umaHoraQuarentaMinutosCincoSegundos.hours() == 1);
		System.out.println(umaHoraQuarentaMinutosCincoSegundos.minutes() == 40);
		System.out.println(umaHoraQuarentaMinutosCincoSegundos.seconds() == 5);
		// deve ser imutável
		//System.out.println(zero.hours() == 0);
		//System.out.println(zero.minutes() == 0);
		//System.out.println(zero.seconds() == 0);

		// plus
		Time tresHorasVinteMinDezSeg = umaHoraQuarentaMinutosCincoSegundos.plus(umaHoraQuarentaMinCincoSeg);
		System.out.println(tresHorasVinteMinDezSeg); // 03:20:10
		System.out.println(tresHorasVinteMinDezSeg.toString().equals("03:20:10"));
		// implementar equals
		System.out.println(tresHorasVinteMinDezSeg.equals(new Time(3, 20, 10)));

		Time duasHorasQuarentaMinCincoSeg = umaHoraQuarentaMinCincoSeg.plusHours(1);
		System.out.println(duasHorasQuarentaMinCincoSeg); // 02:40:05
		System.out.println(duasHorasQuarentaMinCincoSeg.toString().equals("02:40:05"));

		Time duasHorasVinteMinDezSeg = tresHorasVinteMinDezSeg.plusHours(23);
		System.out.println(duasHorasVinteMinDezSeg); // 02:20:10
		System.out.println(duasHorasVinteMinDezSeg.toString().equals("02:20:10"));

		Time duasHorasTrintaMinDezSeg = duasHorasVinteMinDezSeg.plusMinutes(10);
		System.out.println(duasHorasTrintaMinDezSeg); // 02:30:10
		System.out.println(duasHorasTrintaMinDezSeg.toString().equals("02:30:10"));

		Time duasHorasTrintaUmMinTrintaSeg = duasHorasTrintaMinDezSeg.plusSeconds(80);
		System.out.println(duasHorasTrintaUmMinTrintaSeg); // 02:31:30
		System.out.println(duasHorasTrintaUmMinTrintaSeg.toString().equals("02:31:30"));

		Time dezenoveHorasVinteTresMinDezoitoSeg = new Time().plusHours(19).plusMinutes(23).plusSeconds(18);
		System.out.println(dezenoveHorasVinteTresMinDezoitoSeg); // 19:23:18
		System.out.println(dezenoveHorasVinteTresMinDezoitoSeg.toString().equals("19:23:18"));

		Time dezoitoHorasVinteDoisMinDezesseteSeg = dezenoveHorasVinteTresMinDezoitoSeg.plusHours(-1).plusMinutes(-1)
				.plusSeconds(-1);
		System.out.println(dezoitoHorasVinteDoisMinDezesseteSeg); // 18:22:17
		System.out.println(dezoitoHorasVinteDoisMinDezesseteSeg.toString().equals("18:22:17"));

		Time dezesseisHorasVinteMinQuinzeSeg = dezoitoHorasVinteDoisMinDezesseteSeg.minusHours(2).minusMinutes(2)
				.minusSeconds(2);
		System.out.println(dezesseisHorasVinteMinQuinzeSeg); // 16:20:15
		System.out.println(dezesseisHorasVinteMinQuinzeSeg.toString().equals("16:20:15"));

		Time vinteUmaHorasVinteMinQuinzeSeg = dezesseisHorasVinteMinQuinzeSeg.minusHours(-5);
		System.out.println(vinteUmaHorasVinteMinQuinzeSeg); // 21:20:15
		System.out.println(vinteUmaHorasVinteMinQuinzeSeg.toString().equals("21:20:15"));

		Time dezenoveHoras = dezesseisHorasVinteMinQuinzeSeg.minus(vinteUmaHorasVinteMinQuinzeSeg);
		System.out.println(dezenoveHoras); // 19:00:00
		System.out.println(dezenoveHoras.toString().equals("19:00:00"));
		System.out.println(dezenoveHoras.isMidDay() == false);

		Time meiaNoite = dezenoveHoras.minus(dezenoveHoras);
		System.out.println(meiaNoite); // 00:00:00
		System.out.println(meiaNoite.toString().equals("00:00:00"));
		System.out.println(meiaNoite.isMidDay() == false);
		System.out.println(meiaNoite.isMidNight() == true);
		System.out.println(meiaNoite.plusHours(12).isMidDay() == true);
		System.out.println(meiaNoite.equals(zero) == true);

		Time tresHorasQuarentaMin = new Time(3, 40);
		System.out.println(tresHorasQuarentaMin); // 03:40:00
		System.out.println(tresHorasQuarentaMin.toString().equals("03:40:00"));

		Time quinzeHorasQuarentaMin = tresHorasQuarentaMin.shift();
		System.out.println(quinzeHorasQuarentaMin); // 15:40:00
		System.out.println(quinzeHorasQuarentaMin.toString().equals("15:40:00"));

		Time tresHorasQuarentaMinutos = quinzeHorasQuarentaMin.shift();
		System.out.println(tresHorasQuarentaMinutos); // 03:40:00
		System.out.println(tresHorasQuarentaMinutos.toString().equals("03:40:00"));

		Time tresHorasQuarentaMinutosUmSegundo = tresHorasQuarentaMinutos.tick();
		System.out.println(tresHorasQuarentaMinutosUmSegundo); // 03:40:01
		System.out.println(tresHorasQuarentaMinutosUmSegundo.toString().equals("03:40:01"));

		Time tresHorasQuarentaMinutosQuatroSegundos = tresHorasQuarentaMinutosUmSegundo.tick().tick().tick();
		System.out.println(tresHorasQuarentaMinutosQuatroSegundos); // 03:40:04
		System.out.println(tresHorasQuarentaMinutosQuatroSegundos.toString().equals("03:40:04"));

		Time quantoEuValho = tresHorasQuarentaMinutosQuatroSegundos.plusHours(50).plusMinutes(50).minusSeconds(50).tick().shift();
		System.out.println(quantoEuValho); // quanto?

		Time noveQuarentaQuinze = new Time(9, 40, 15);
		// representação string, padrão 00:00:00
		System.out.println(noveQuarentaQuinze); // 09:40:15
		System.out.println(noveQuarentaQuinze.toString().equals("09:40:15"));
		// representação string com formato alternativo
		System.out.println(noveQuarentaQuinze.toLongString()); // 9 horas 40 minutos e 15 segundos
		System.out.println(noveQuarentaQuinze.toLongString().equals("9 horas 40 minutos e 15 segundos"));

		// fromString, formato 00:00:00
		Time umaHoraTrintaSeisMinutos = Time.fromString("01:36:00");
		System.out.println(umaHoraTrintaSeisMinutos.toLongString()); // 1 hora e 36 minutos
		System.out.println(umaHoraTrintaSeisMinutos.toLongString().equals("1 hora e 36 minutos"));

		// fromDouble
		Time tresPontoOitocentosVinteQuatroHoras = Time.fromDouble(3.824);
		System.out.println(tresPontoOitocentosVinteQuatroHoras.toLongString()); // 3 horas 49 minutos e 26 segundos
		System.out.println(tresPontoOitocentosVinteQuatroHoras.toLongString().equals("3 horas 49 minutos e 26 segundos"));
		// sem arredondamentos
		System.out.println(Time.fromDouble(17.1447).toLongString()); // 17 horas 8 minutos e 40 segundos
		System.out.println(Time.fromDouble(17.1447).toLongString().equals("17 horas 8 minutos e 40 segundos"));

		// fromSeconds
		Time setentaSeisMilSeiscentosTrintaDoisSegundos = Time.fromSeconds(76632);
		System.out.println(setentaSeisMilSeiscentosTrintaDoisSegundos.toLongString()); // 21 horas 17 minutos e 12 segundos
		System.out
				.println(setentaSeisMilSeiscentosTrintaDoisSegundos.toLongString().equals("21 horas 17 minutos e 12 segundos"));
		System.out.println(Time.fromSeconds(68400).toLongString()); // 19 horas
		System.out.println(Time.fromSeconds(68400).toLongString().equals("19 horas"));

		// toDouble
		Time dezesseisHorasQuarentaCincoMinOnzeSeg = Time.fromString("16:45:11");
		System.out.println(dezesseisHorasQuarentaCincoMinOnzeSeg.toDouble()); // 16.75305556 aproximadamente
		System.out.println(dezesseisHorasQuarentaCincoMinOnzeSeg.toDouble() == 16.75305556); // faça o ajuste para o valor
																																													// correto retornado
		System.out.println(Time.fromString("13:04:59").toDouble()); // 13.08305556 aproximadamente
		System.out.println(Time.fromString("13:04:59").toDouble() == 13.08305556); // faça o ajuste para o valor correto
																																								// retornado
		double trezePontoUnsQuebradosHoras = Time.fromString("13:04:59").toDouble();
		Time trezeHorasQuatroMinutosCinquentaNoveSegundos = Time.fromDouble(trezePontoUnsQuebradosHoras);
		System.out.println(trezeHorasQuatroMinutosCinquentaNoveSegundos.toLongString()); // 13 horas 4 minutos e 59 segundos
		System.out.println(trezeHorasQuatroMinutosCinquentaNoveSegundos.toLongString().equals("13 horas 4 minutos e 59 segundos"));

		// fromTime
		Time trezeHorasQuatroMinutosCinquentaNoveSegundosCopia = Time.from(trezeHorasQuatroMinutosCinquentaNoveSegundos);
		// toShortString
		System.out.println(trezeHorasQuatroMinutosCinquentaNoveSegundosCopia.toShortString()); // 13h04m59s
		System.out.println(trezeHorasQuatroMinutosCinquentaNoveSegundosCopia.toShortString().equals("13h04m59s"));
		System.out.println(Time.fromString("15:03:00").toShortString()); // 15h03m
		System.out.println(Time.fromString("15:03:00").toShortString().equals("15h03m"));
		System.out.println(Time.fromString("15:00:01").toShortString()); // 15h00m01s
		System.out.println(Time.fromString("15:00:01").toShortString().equals("15h00m01s"));

		// constantes de classe (atributos estáticos)
		Time meioDia = Time.MIDDAY;
		System.out.println(meioDia.toShortString()); // 12h
		System.out.println(meioDia.toShortString().equals("12h"));
		System.out.println(Time.MIDDAY.toInt() == 43200); // segundos
		System.out.println(Time.MIDDAY.toDouble() == 12.0); // horas

		Time meiaNoite2 = Time.MIDNIGHT;
		System.out.println(meiaNoite2.toShortString()); // 00h
		System.out.println(meiaNoite2.toShortString().equals("00h"));
		System.out.println(Time.MIDNIGHT.toInt() == 0);
		System.out.println(Time.MIDNIGHT.toDouble() == 0.0);

		// construtores:
		Comprimento zero1 = new Comprimento();
		System.out.println(zero1.milimetros == 0);

		// milimetros é constante, não deve compilar:
		//zero.milimetros = 10; // comente essa linha após fazê-la falhar

		// construtor double metro:
		Comprimento umMetro = new Comprimento(1.0);
		System.out.println(umMetro.milimetros == 1000);

		Comprimento umMetroMeio = new Comprimento(1.5);
		System.out.println(umMetroMeio.milimetros == 1500);

		Comprimento cemMetros = new Comprimento(100.0);
		System.out.println(cemMetros.milimetros == 100000);

		// construtor inteiro milimetros:
		Comprimento umCentimetro = new Comprimento(100);
		System.out.println(umCentimetro.milimetros == 100);

		// comprimentos inválidos, negativo!
		// Faça lançar exceção e abrace-as com try/catch
		try
		{Comprimento invalido1 = new Comprimento(-1.0);
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		try
		{Comprimento invalido2 = new Comprimento(-10);
		}catch(Exception e){
			System.err.println(e.getMessage());
		}

		// métodos estáticos fábrica:
		Comprimento umaPolegada = Comprimento.fromPolegadas(1.0);
		System.out.println(umaPolegada.milimetros == 25);

		Comprimento cincoPolegadas = Comprimento.fromPolegadas(5.0);
		System.out.println(cincoPolegadas.milimetros == 127);

		Comprimento dozeMilimetros = Comprimento.fromString("12mm");
		System.out.println(dozeMilimetros.milimetros == 12);

		Comprimento dozeCentimetros = Comprimento.fromString("12cm");
		System.out.println(dozeCentimetros.milimetros == 120);

		Comprimento dozePolegadas = Comprimento.fromString("12\"");
		// seria 304.8mm, mas os mm devem ser truncados, não arredondados.
		System.out.println(dozePolegadas.milimetros == 304);

		Comprimento dozeMetros = Comprimento.fromString("12m");
		System.out.println(dozeMetros.milimetros == 12000);

		try{
			Comprimento.fromString("12");
		}catch(Exception e){
			System.err.println(e.getMessage());
		}

		try {
			Comprimento.fromString("12e");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		try {
			Comprimento.fromString("12 m");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		try {
			Comprimento.fromString("12M");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		// consultas: (pode ser ajustado para o arredondamento, exceto de mm que é
		// truncado)
		System.out.println(cincoPolegadas.getCentimetros() == 12.7);
		System.out.println(cincoPolegadas.getMetros() == 0.127);
		System.out.println(cemMetros.getPolegadas() == 3937.0);
		System.out.println(dozeMetros.getMilimetros() == 12000);

		System.out.println(umMetro.toString()); // 1000mm
		System.out.println(umMetro.toString().equals("1000mm"));
		System.out.println(umMetroMeio.toString()); // 1500mm
		System.out.println(umMetroMeio.toString().equals("1500mm"));
		System.out.println(cemMetros.toString()); // 100000mm
		System.out.println(cemMetros.toString().equals("100000mm"));

		// Unidade é um enum declarado dentro da classe Comprimento com as seguintes
		// constantes:
		System.out.println(umMetro.toString(Comprimento.Unidade.POLEGADA)); // 39.37"
		System.out.println(umMetro.toString(Comprimento.Unidade.POLEGADA).equals("39.37\""));
		System.out.println(umMetroMeio.toString(Comprimento.Unidade.CENTIMETRO)); // 150cm
		System.out.println(umMetroMeio.toString(Comprimento.Unidade.CENTIMETRO).equals("150cm"));
		System.out.println(cemMetros.toString(Comprimento.Unidade.METRO)); // 100m
		System.out.println(cemMetros.toString(Comprimento.Unidade.METRO).equals("100m"));
		System.out.println(cemMetros.toString(Comprimento.Unidade.KILOMETRO)); // 0.1km
		System.out.println(cemMetros.toString(Comprimento.Unidade.KILOMETRO).equals("0.1km"));

		// operações: (Comprimento é imutável)
		Comprimento doisMetrosMeio = umMetro.mais(umMetroMeio);
		System.out.println(umMetro.milimetros == 1000);
		System.out.println(umMetroMeio.milimetros == 1500);
		System.out.println(doisMetrosMeio.milimetros == 2500);

		Comprimento dezMetros = doisMetrosMeio.mais(7.5); // 2.5m + 7.5m
		System.out.println(dezMetros.milimetros == 10000);

		Comprimento dezMetrosComOitentaMilimetros = dezMetros.mais(80); // + 80mm
		System.out.println(dezMetrosComOitentaMilimetros.milimetros == 10080);

		Comprimento vinteMetros = dezMetros.dobro();
		System.out.println(vinteMetros.milimetros == 20000);

		Comprimento duzentosMetros = vinteMetros.vezes(10);
		System.out.println(duzentosMetros.milimetros == 200000);
		System.out.println(duzentosMetros.toString(Comprimento.Unidade.KILOMETRO)); // 0.2km
		System.out.println(duzentosMetros.toString(Comprimento.Unidade.KILOMETRO).equals("0.2km"));

		// Spock é um Funcionário
		// Ponto representa a presença do funcionário
		// Ponto é mutável, pois representa um processo ao longo do tempo!!!
		Ponto pontoSpock = new Ponto("Spock");
		// toString
		System.out.println(pontoSpock); // Spock não bateu ponto
		// Spock bateu ponto às 07:50:15
		pontoSpock.bater("07:50:15");
		System.out.println(pontoSpock); // Spock entrou às 07h50m15s
		System.out.println(pontoSpock.toString().equals("Spock entrou às 07h50m15s")); //
		pontoSpock.bater("12:02:10");



  }
}
