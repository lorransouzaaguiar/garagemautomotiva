package produto.presentation.util;

public enum ProductMsg {
	NEW_SUCCESS("Produto salvo com sucesso!"),
	NEW_ERROR("Falha ao salvar produto!"),
	EDIT_SUCCESS("Produto atualizado com sucesso!!"),
	EDIT_ERROR("Falha ao atualizar produto!"),
	DELETE_SUCCESS("Produto deletado com sucesso!"),
	DELETE_ERROR("Falha ao deletar produto!"),
	SEARCH_SUCCESS("Produto obtido com sucesso!"),
	SEARCH_ERROR("Falha ao obter produto!"),
	SEARCHFIELD_EMPTY("Insira a descrição do produto a ser pesquisado!"),
	TABLE_WARNING("Selecione um produto na tabela");
	
	private String message;
	
	ProductMsg(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
	
}
