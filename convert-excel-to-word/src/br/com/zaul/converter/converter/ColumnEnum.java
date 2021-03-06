package br.com.zaul.converter.converter;

enum ColumnEnum {

	NAME("Name", 2, "Nome"),
	DESCRIPTION("Description", 3, "Descri��o"),
	ASSOCIATED_BUSINESS_PROCESS("AssociatedBusinessProcess", 4, "Processo de Neg�cio Associados"),
	FUNCTIONAL_AREAS("FunctionalAreas", 5, "�reas Funcionais"),
	BUSINESS_ACTORES("BusinessActores", 6, "Atores do Neg�cio"),
	CONTRACT_AND_OPERATIONS("ContractAndOperations", 7, "Contratos e Opera��es"),
	OPERATIONS_MESSAGES("OperationsMessages", 8, "Mensagens de Opera��es"),
	SLA("Sla", 9, "SLA"),
	SERVICE_DEPENDENCY_AND_COMPOSITION("ServiceDependencyAndComposition", 10, "Depend�ncia de Servi�os e Composi��es"),
	TRACEABILITY("Traceability", 11, "Rastreabilidade");
	
	String methodName;
	Integer columnPosition;
	String title;
	
	ColumnEnum(String methodName, Integer columnPosition, String title) {
		this.methodName = methodName;
		this.columnPosition = columnPosition;
		this.title = title;
	}
	
	public String getMethodName() {
		return "get" + this.methodName;
	}
	
	public String setMethodName() {
		return "set" + this.methodName;
	}

	public Integer getColumnPosition() {
		return this.columnPosition;
	}
	
	public String getTitle() {
		return this.title;
	}
}
