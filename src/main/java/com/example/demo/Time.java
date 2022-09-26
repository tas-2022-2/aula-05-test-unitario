package com.example.demo;

public class Time {
	public static final Time MIDDAY = new Time(12,0,0);
	public static final Time MIDNIGHT = new Time(0,0,0);
	private int hora;
	private int minutos;
	private int segundos;

	public void converterHora(){
		do{
			this.hora=this.hora-24;
		}while(this.hora > 24);
	}

	public int hours() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int minutes() {
		return minutos;
	}


	public int seconds() {
		return segundos;
	}



	public void converterMinuto() {
		do {
			this.minutos = this.minutos - 60;
			this.hora=this.hora+1;
		} while (this.minutos > 60);

		if(this.hora > 24){
			this.converterHora();
		}
	}

	public void converterSegundos() {
		do {
			this.segundos = this.segundos - 60;
			this.minutos=this.minutos+1;
		} while (this.hora > 60);

		if(this.minutos > 60){
			this.converterMinuto();
		}
	}



	public Time(int hora, int minutos, int segundos) {


		this.hora = hora;
		this.minutos = minutos;
		this.segundos = segundos;
	}

	public Time(int hora, int minutos) {
		this.hora = hora;
		this.minutos = minutos;
		this.segundos = 0;
	}

	public Time(int hora) {
		this.hora = hora;
		this.minutos = 0;
		this.segundos = 0;
	}

	public Time() {
		this.hora=0;
		this.minutos=0;
		this.segundos=0;
	}

	public Time(String tempo){
		for(int i=0;i<tempo.length();i++){
			if(tempo.charAt(i)==':'){
				i++;

			}else{
				this.hora=this.hora+tempo.charAt(i);
			}
		}
	}

	public static Time fromString(String time){
		String temphora = "";
		String tempminutos = "";
		String tempsegundos = "";

		temphora = temphora + time.charAt(0) + time.charAt(1);
		tempminutos = tempminutos + time.charAt(3) + time.charAt(4);
		tempsegundos=tempsegundos+time.charAt(6)+time.charAt(7);



		return new Time (Integer.parseInt(temphora),Integer.parseInt(tempminutos), Integer.parseInt(tempsegundos) );

	}

	public static Time fromDouble(double duplotempo) {
		int horaInteger = (int)duplotempo;
		double tempMinutoDouble= duplotempo-horaInteger;
		double minutoDouble= tempMinutoDouble*60;
		int minutoInteger = (int)minutoDouble;
		double tempSegundosDouble= minutoDouble-minutoInteger;
		double segundosDouble=tempSegundosDouble*60;
		int segundoInteger = (int)segundosDouble;


		return new Time (horaInteger,minutoInteger,segundoInteger);
	}

	public static Time fromSeconds(int secundos){
		double temp = (double)secundos / 3600;
		int horaInteger = (int) temp;
		double tempMinutoDouble = temp - horaInteger;
		double minutoDouble = tempMinutoDouble * 60;
		int minutoInteger = (int) minutoDouble;
		double tempSegundosDouble = minutoDouble - minutoInteger;
		double segundosDouble = tempSegundosDouble * 60;
		int segundoInteger = (int) segundosDouble;

		return new Time(horaInteger, minutoInteger, segundoInteger);
	}

	public static Time from(Time relogio){
		return new Time (relogio.hora, relogio.minutos, relogio.segundos);
	}



	@Override
	public String toString() {
		String hr="";
		String min="";
		String sec="";

		if(this.hora < 10){
			hr="0";
		}

		if(this.minutos < 10){
			min="0";
		}

		if (this.segundos < 10){
			sec="0";
		}

		return hr + hora + ":" + min + minutos + ":" + sec +  segundos;
	}

	public String toLongString(){
		String hr = "";
		String min = "";
		String sec = "";

		if (this.hora < 2) {
			hr = " hora";
		}else{
			hr = " horas";
		}

		if (this.minutos < 2) {
			min = " minuto";
		}else{
			min = " minutos";
		}

		if (this.segundos < 2) {
			sec = " segundo";
		}else{
			sec = " segundos";
		}

		if (this.minutos <= 0 & this.segundos <= 0) {
			return hora + hr;
		}

		if(this.segundos<=0){
			return hora + hr +" e "+ minutos + min;
		}

		if(this.minutos<=0){
			return hora + hr +" e " + segundos + sec;
		}

		return hora + hr +" "+ minutos + min +" e "+ segundos + sec;
	}

	public String toShortString(){
		String hr = "";
		String min = "";
		String sec = "";

		if (this.hora < 10) {
			hr = "0";
		}

		if (this.minutos < 10) {
			min = "0";
		}

		if (this.segundos < 10) {
			sec = "0";
		}

		if (this.minutos <= 0 & this.segundos <= 0) {
			return hr + hora + "h";
		}

		if (this.segundos <= 0) {
			return hr+hora +"h" + min+ minutos + "m";
		}



		return hr+hora+"h"+min+minutos+"m"+sec+segundos+"s";
	}

	public double toDouble(){
		double tempHora=(double)this.hora;
		double tempSegundosDouble=(double)this.segundos / 60;
		double tempMinutosDouble= (double)this.minutos + tempSegundosDouble;
		double decimalHora=tempMinutosDouble / 60;
		double horaToDouble= tempHora+decimalHora;
		return horaToDouble;
	}

	public int toInt(){
		int tempHora=this.hora*3600;
		int tempMinutos=this.minutos*60;
		int resultado=tempHora+tempMinutos+this.segundos;
		return resultado;
	}

	public Time plus(Time horario){
		this.hora = this.hora + horario.hora;
		this.minutos = this.minutos + horario.minutos;
		this.segundos = this.segundos + horario.segundos;

		if(this.hora > 24){
			this.converterHora();
		}

		if(this.minutos > 60){
			this.converterMinuto();
		}

		if(this.segundos > 60){
			this.converterSegundos();
		}

		return this;

	}

	public Time plusHours(int hour){
		this.hora=this.hora+hour;
		if(this.hora > 24){
			this.converterHora();
		}

		return this;
	}

	public Time plusMinutes(int minutes){
		this.minutos=this.minutos+minutes;

		if(this.minutos > 60){
			this.converterMinuto();
		}

		return this;
	}

	public Time plusSeconds(int seconds){
		this.segundos=this.segundos+seconds;
		if(this.segundos > 60 ){
			this.converterSegundos();
		}
		return this;
	}

	public Time minus(Time tempo){
		this.hora=this.hora-tempo.hora;
		this.minutos=this.minutos-tempo.minutos;
		this.segundos=this.segundos-tempo.segundos;

		if (this.hora < 0) {
			this.hora = this.hora + 24;
		}

		if (this.minutos < 0) {
			this.minutos = this.minutos + 60;
		}

		if (this.segundos < 0) {
			this.segundos = this.segundos + 60;
		}

		return this;
	}

	public Time minusHours(int hour){
		this.hora=this.hora-hour;

		if(this.hora < 0){
			this.hora=this.hora+24;
		}

		return this;
	}

	public Time minusMinutes(int minutes){
		this.minutos=this.minutos-minutes;

		if(this.minutos < 0){
			this.minutos=this.minutos+60;
		}

		return this;
	}

	public Time minusSeconds(int seconds){
		this.segundos=this.segundos-seconds;

		if(this.segundos < 0){
			this.segundos=this.segundos+60;
		}
		return this;
	}

	public Time tick(){
		this.segundos=this.segundos+1;

		if (this.segundos > 60){
			this.converterSegundos();
		}

		return this;
	}

	public Time shift(){
		this.hora=this.hora+12;

		if(this.hora > 24){
			this.converterHora();
		}

		return this;
	}

	public boolean isMidDay(){
		if(this.hora==12){
			return true;
		}else{
			return false;
		}
	}

	public boolean isMidNight(){
		if(this.hora==0){
			return true;
		}else{
			return false;
		}
	}


	public boolean equals(Time tiempo){
		if (this.hora == tiempo.hora && this.minutos == tiempo.minutos && this.segundos == tiempo.segundos){
			return true;
		}else{
			return false;
		}
	}





}
