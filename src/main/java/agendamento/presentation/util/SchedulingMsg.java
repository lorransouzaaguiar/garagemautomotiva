package agendamento.presentation.util;

public enum SchedulingMsg {
	NEW_SUCCESS("Agendamento salvo com sucesso!"),
	NEW_ERROR("Falha ao salvar agendamento!"),
	EDIT_SUCCESS("Agendamento atualizado com sucesso!"),
	EDIT_ERROR("Falha ao atualizar agendamento!"),
	DELETE_SUCCESS("Agendamento deletado com sucesso!"),
	DELETE_ERROR("Falha ao deletar agendamento!"),
	SEARCH_SUCCESS("Agendamento obtido com sucesso!"),
	SEARCH_ERROR("Falha ao obter agendamento!"),
	SEARCH_EMPTY("Nenhum agendamento encontrado para esta data"),
	SEARCHFIELD_EMPTY("Insira o nome do agendamento a ser pesquisado!"),
	TABLE_WARNING("Selecione um agendamento na tabela");
	
	private String message;
	
	SchedulingMsg(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
