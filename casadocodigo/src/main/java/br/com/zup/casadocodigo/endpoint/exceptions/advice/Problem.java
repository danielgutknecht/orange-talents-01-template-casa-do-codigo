package br.com.zup.casadocodigo.endpoint.exceptions.advice;

import java.time.OffsetDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Problem {

	// @ApiModelProperty(example = "400", position = 1)
	private Integer status;

	// @ApiModelProperty(example = "2019-12-01T18:09:02.70844Z", position = 5)
	private OffsetDateTime timestamp;

	// @ApiModelProperty(example = "https://localhost:8080/dados-invalidos",
	// position = 10)
	private String type;

	// @ApiModelProperty(example = "Dados inválidos", position = 15)
	private String title;

	// @ApiModelProperty(example = "Um ou mais campos estão inválidos. Faça o
	// preenchimento correto e tente novamente.", position = 20)
	private String detail;

	// @ApiModelProperty(example = "Um ou mais campos estão inválidos. Faça o
	// preenchimento correto e tente novamente.", position = 25)
	private String userMessage;

	// @ApiModelProperty(value = "Lista de objetos ou campos que geraram o erro
	// (opcional)", position = 30)
	private List<Object> objects;

	public Problem(Integer status, OffsetDateTime timestamp, String type, String title, String detail,
			String userMessage, List<Object> objects) {
		super();
		this.status = status;
		this.timestamp = timestamp;
		this.type = type;
		this.title = title;
		this.detail = detail;
		this.userMessage = userMessage;
		this.objects = objects;
	}

	public Integer getStatus() {
		return status;
	}

	public OffsetDateTime getTimestamp() {
		return timestamp;
	}

	public String getType() {
		return type;
	}

	public String getTitle() {
		return title;
	}

	public String getDetail() {
		return detail;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public List<Object> getObjects() {
		return objects;
	}

	// @Builder
	public static class Object {

		private String name;

		private String userMessage;

		public String getName() {
			return name;
		}

		public String getUserMessage() {
			return userMessage;
		}

		public static final class Builder {
			// @ApiModelProperty(example = "400", position = 1)
			private String name;
			// @ApiModelProperty(example = "2020-01-16T13:45:00.70844Z", position = 5)
			private String userMessage;

			public Builder() {
			}

			public Builder(String name, String userMessage) {
				this.name = name;
				this.userMessage = userMessage;
			}

			public static Builder newBuilder() {
				return new Builder();
			}

			public Builder name(String name) {
				this.name = name;
				return this;
			}

			public Builder userMessage(String userMessage) {
				this.userMessage = userMessage;
				return this;
			}

			public Object build() {
				Object object = new Object();
				object.name = this.name;
				object.userMessage = this.userMessage;

				return object;
			}
		}
	}

	public static final class Builder {
		// @ApiModelProperty(example = "400", position = 1)
		private Integer status;
		// @ApiModelProperty(example = "2020-01-16T13:45:00.70844Z", position = 5)
		private OffsetDateTime timestamp;
		// @ApiModelProperty(example = "https://localhost:8080/dados-invalidos",
		// position = 10)
		private String type;
		// @ApiModelProperty(example = "Dados inválidos", position = 15)
		private String title;
		// @ApiModelProperty(example = "Um ou mais campos estão inválidos. Faça o
		// preenchimento correto e tente novamente.", position = 20)
		private String detail;
		// @ApiModelProperty(example = "Um ou mais campos estão inválidos. Faça o
		// preenchimento correto e tente novamente.", position = 25)
		private String userMessage;
		// @ApiModelProperty(value = "Lista de objetos ou campos que geraram erro
		// (opcional)", position = 30)
		private List<Object> objects;

		private Builder() {
		}

		public static Builder newbuilder() {
			return new Builder();
		}

		public Builder status(Integer status) {
			this.status = status;
			return this;
		}

		public Builder timestamp(OffsetDateTime timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public Builder type(String type) {
			this.type = type;
			return this;
		}

		public Builder title(String title) {
			this.title = title;
			return this;
		}

		public Builder detail(String detail) {
			this.detail = detail;
			return this;
		}

		public Builder userMessage(String userMessage) {
			this.userMessage = userMessage;
			return this;
		}

		public Builder objects(List<Object> objects) {
			this.objects = objects;
			return this;
		}

		public Problem build() {

			return new Problem(status, timestamp, type, title, detail, userMessage, objects);
		}

	}
}
