package br.com.zaul.converter.converter;

enum ColumnEnum {

	NAME("getName", "setName", 2, "Nome"),
	DESCRIPTION("getDescription", "setDescription", 3, "Descrição"),
	ASSOCIATED_BUSINESS_PROCESS("getAssociatedBusinessProcess", "setAssociatedBusinessProcess", 4, "Processo de Negócio Associados"),
	FUNCTIONAL_AREAS("getFunctionalAreas", "setFunctionalAreas", 5, "Áreas Funcionais"),
	BUSINESS_ACTORES("getBusinessActores", "setBusinessActores", 6, "Atores do Negócio"),
	CONTRACT_AND_OPERATIONS("getContractAndOperations", "setContractAndOperations", 7, "Contratos e Operações"),
	OPERATIONS_MESSAGES("getOperationsMessages", "setOperationsMessages", 8, "Mensagens de Operações"),
	SLA("getSla", "setSla", 9, "SLA"),
	SERVICE_DEPENDENCY_AND_COMPOSITION("getServiceDependencyAndComposition", "setServiceDependencyAndComposition", 10, "Dependência de Serviços e Composições"),
	TRACEABILITY("getTraceability", "setTraceability", 11, "Rastreabilidade");
	
	String getMethodName;
	String setMethodName;
	Integer columnPosition;
	String title;
	
	ColumnEnum(String methodName, String setMethodName, Integer columnPosition, String title) {
		this.getMethodName = methodName;
		this.setMethodName = setMethodName;
		this.columnPosition = columnPosition;
		this.title = title;
	}
	
	public String methodName() {
		return this.getMethodName;
	}
	
	public String getMethodName() {
		return this.getMethodName;
	}
	
	public String setMethodName() {
		return this.setMethodName;
	}

	public Integer getColumnPosition() {
		return this.columnPosition;
	}
	
	public String getTitle() {
		return this.title;
	}
}
