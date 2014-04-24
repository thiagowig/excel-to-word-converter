package br.com.zaul.converter.converter;

enum ColumnEnum {

	NAME("Name", 2, "Nome"),
	DESCRIPTION("Description", 3, "Descrição"),
	ASSOCIATED_BUSINESS_PROCESS("AssociatedBusinessProcess", 4, "Processo de Negócio Associados"),
	FUNCTIONAL_AREAS("FunctionalAreas", 5, "Áreas Funcionais"),
	BUSINESS_ACTORES("BusinessActores", 6, "Atores do Negócio"),
	CONTRACT_AND_OPERATIONS("ContractAndOperations", 7, "Contratos e Operações"),
	OPERATIONS_MESSAGES("OperationsMessages", 8, "Mensagens de Operações"),
	SLA("Sla", 9, "SLA"),
	SERVICE_DEPENDENCY_AND_COMPOSITION("ServiceDependencyAndComposition", 10, "Dependência de Serviços e Composições"),
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
