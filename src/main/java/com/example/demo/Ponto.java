package com.example.demo;

public class Ponto {
	private final String nomeFuncionario;
	private Time horarioEntra = new Time();
	private Time horarioSai = new Time();
	private boolean entrou = false;
	private boolean saiu = false;



	public Ponto(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}



	public void bater(String horario){
		if(this.entrou==false){
			this.horarioEntra=Time.fromString(horario);
			this.entrou=true;
		}else if(this.saiu==false){
			this.horarioSai= Time.fromString(horario);
			this.saiu=true;
		}else if(this.entrou==true & this.saiu==true){
			throw new IllegalStateException("Ponto fechado não pode ser batido");
		}
	}

	public String toString(){
		if(entrou==true){
			return nomeFuncionario +" entrou às "+ this.horarioEntra.toShortString();
		}

		return nomeFuncionario+" não bateu ponto";
	}



}
