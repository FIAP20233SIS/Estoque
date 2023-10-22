package br.com.fiap.estoque.infrastructure.exception;

@SuppressWarnings("serial")
public class BusinessException extends NestedException {

	private final String resourceId;
	private final String[] args;

	public BusinessException(String resourceId, String... args) {
		super(resourceId);
		this.resourceId = resourceId;
		this.args = args.clone();
	}

	public BusinessException(String resourceId, String message, Exception exception) {
		super(message, exception);
		this.resourceId = resourceId;
		this.args = null;
	}

	public BusinessException(String resourceId, Exception exception, String... args) {
		super(resourceId, exception);
		this.resourceId = resourceId;
		this.args = args.clone();
	}

	public String[] getArgs() {
		return this.args.clone();
	}

	public String getResourceId() {
		return this.resourceId;
	}

	@Override
	public String getMessage() {
		return this.getResourceId();
	}

	@Override
	public String getLocalizedMessage() {
		return this.getResourceId();
	}
}
