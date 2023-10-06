package com.sap.olingo.jpa.processor.core.api;

import java.util.List;
import java.util.Optional;

import org.apache.olingo.commons.api.edm.EdmEntitySet;
import org.apache.olingo.commons.api.format.ContentType;
import org.apache.olingo.server.api.OData;
import org.apache.olingo.server.api.ODataRequest;
import org.apache.olingo.server.api.ODataResponse;
import org.apache.olingo.server.api.ODataServerError;
import org.apache.olingo.server.api.ServiceMetadata;
import org.apache.olingo.server.api.processor.DefaultProcessor;
import org.apache.olingo.server.api.processor.ErrorProcessor;

public final class JPADefaultErrorProcessor implements ErrorProcessor {
	private final ErrorProcessor defaultProcessor;

	private ServiceMetadata serviceMetadata;
	private static final String Invalid_Key_Error_Message = "The key value is not valid.";
	private static final String Updated_Invalid_key_Error_Message= "For the given EntityType %s, the key should be of type %s";
	
	JPADefaultErrorProcessor() {
		super();
		defaultProcessor = new DefaultProcessor();

	}

	@Override
	public void init(OData odata, ServiceMetadata serviceMetadata) {
		defaultProcessor.init(odata, serviceMetadata);
		this.serviceMetadata = serviceMetadata;
	}

	@Override
	public void processError(ODataRequest request, ODataResponse response, ODataServerError serverError,
			ContentType responseFormat) {
		String errorMessage = serverError.getException().getMessage();
		if (errorMessage.equals(Invalid_Key_Error_Message) && serverError.getStatusCode() == 400) {
			Optional<String> message = getUpdatedMessageForInvalidKeyMessage(request);
			if (message.isPresent())
				serverError.setMessage(message.get());
		}
		defaultProcessor.processError(request, response, serverError, responseFormat);
	}

	private Optional<String> getUpdatedMessageForInvalidKeyMessage(ODataRequest request) {
		String message = null;
		List<EdmEntitySet> entityList = this.serviceMetadata.getEdm().getEntityContainer().getEntitySets();
		String[] urlSegments = request.getRawODataPath().split("/");
		if (urlSegments.length > 1) {
			String apiPathSegment = urlSegments[1];
			String entityName = apiPathSegment.substring(0, apiPathSegment.indexOf("("));
			for (EdmEntitySet edmEntitySet : entityList) {
				if (edmEntitySet.getName().equalsIgnoreCase(entityName)) {
					message = String.format(Updated_Invalid_key_Error_Message, entityName, getDataTypeOfEntityIdField(edmEntitySet));
				}
			}
		}
		return Optional.ofNullable(message);
	}

	private String getDataTypeOfEntityIdField(EdmEntitySet edmEntitySet) {
		return edmEntitySet.getEntityType().getKeyPropertyRefs().get(0).getProperty().getType().getName();
	}

}
