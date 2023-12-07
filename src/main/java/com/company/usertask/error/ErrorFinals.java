package com.company.usertask.error;

import com.company.usertask.exception.ErrorResponse;
import org.springframework.http.HttpStatus;

public enum ErrorFinals implements ErrorResponse {
    FILE_ALREADY_EXISTS("FILE_ALREADY_EXISTS", HttpStatus.CONFLICT, "bu yolda {path} file artıq mövcuddur"),
    DATA_NOT_FOUND("DATA_NOT_FOUND", HttpStatus.NOT_FOUND, " id-si '{id}' olan '{name}' məlumatı tapılmadı"),
    STATUS_NOT_FOUND("STATUS_NOT_FOUND", HttpStatus.NOT_FOUND, " '{status}' statusu olan '{name}' məlumatı tapılmadı"),
    DATA_NOT_FOUND_LAST("DATA_NOT_FOUND_LAST", HttpStatus.NOT_FOUND, "{message}"),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR, "daxili server xətası"),
    SERVICE_TYPE_ERROR("SERVICE_TYPE_ERROR", HttpStatus.BAD_REQUEST, "{message}"),


    //security exception messages
//    JWT_ERROR("JWT_ERROR",HttpStatus.UNAUTHORIZED,"{message}"),
    ACCESS_DENIED("ACCESS_DENIED", HttpStatus.FORBIDDEN, "İcazə yoxdur"),
    EXPIRED_JWT_ERROR("EXPIRED_JWT_ERROR", HttpStatus.UNAUTHORIZED, "JWT token-in vaxtı keçib"),
    UNSUPPORTED_JWT_ERROR("UNSUPPORTED_JWT_ERROR", HttpStatus.UNAUTHORIZED, "Bu token formatı dəstəklənmir"),
    MALFORMED_JWT_ERROR("MALFORMED_JWT_ERROR", HttpStatus.UNAUTHORIZED, "Token düzgün formatda deyil"),
    SIGNATURE_JWT_ERROR("SIGNATURE_JWT_ERROR", HttpStatus.UNAUTHORIZED, "Token-in signature-i səhvdi"),
    INVALID_TOKEN("INVALID_TOKEN", HttpStatus.UNAUTHORIZED, "Token səhvdi"),

    //for standard exception messages
    UNIQUE_CONSTRAINT("23505", HttpStatus.BAD_REQUEST, "təkrarlana bilməz"),
    FK_CONSTRAINT("23503", HttpStatus.BAD_REQUEST, "əlaqəli olduğu məlumat xətası"),
    NOT_EMPTY_CONSTRAINT("23502", HttpStatus.BAD_REQUEST, "{name} boş ola bilməz"),
    CHECK_VIOLATION("23514", HttpStatus.BAD_REQUEST, "check violation xətası"),

    //    Vacation PDF Generator exception messages
    VACATION_NOT_FOUND("VACATION_NOT_FOUND", HttpStatus.NOT_FOUND, "vacation is not found"),
    VACATION_NOT_FOUND_DURING_PRINT("VACATION_NOT_FOUND_DURING_PRINT", HttpStatus.NOT_FOUND, "vacation info is not found during print"),
    GENERATE_PDF_EXCEPTION("GENERATE_PDF_EXCEPTION", HttpStatus.INTERNAL_SERVER_ERROR, "pdf file generation exception"),
    GENERATE_PDF_OTHER_EXCEPTION("GENERATE_PDF_OTHER_EXCEPTION", HttpStatus.INTERNAL_SERVER_ERROR, "pdf file generation unknown exception"),

    //    Employee Success Degree
    DATE_EXISTS("DATA_EXISTS", HttpStatus.BAD_REQUEST, "bu tarix - {create date} bazada artıq mövcuddur!"),

    // Employee data in use
    DATA_IN_USE("DATA_IN_USE", HttpStatus.BAD_REQUEST, " {id} id-li universitet hazırda istifadə olunur"),

    //    Employee War Activity
    DATE_PRECEDENCE("DATE_PRECEDENCE", HttpStatus.BAD_REQUEST, "bitmə tarixi({finish date}) başlama tarixindən({start date}) sonra gəlməlidir "),

    //    Nomenclature
    SAME_DATA("SAME_DATA", HttpStatus.BAD_REQUEST, "id-lər eyni ola bilməz"),
    NOT_EXTENSION_NOMENCLATURE("NOT_EXTENSION_NOMENCLATURE", HttpStatus.BAD_REQUEST, "Bu id-li - '{id}' nomenklatura daxil edilə bilən nomenklatura deyil"),

    //    Integration
    CREDENTIALS("CREDENTIALS", HttpStatus.BAD_REQUEST, "parametrlərdə xəta var"),
    IAMAS_PIN_NOT_FOUND("PIN_NOT_FOUND", HttpStatus.NOT_FOUND, "{pin} pin-i bazada mövcud deyil."),
    INTEGRATION_ERROR("INTEGRATION_ERROR", HttpStatus.INTERNAL_SERVER_ERROR, "{message}"),
    STRUCTURE_UNIT_BAD_REQUEST("STRUCTURE_UNIT_BAD_REQUEST", HttpStatus.BAD_REQUEST, "daxil edilən structure və ya position id bazada mövcud deyil!"),
    // Police Card
    ID_ALREADY_EXISTS("ID_ALREADY_EXISTS", HttpStatus.BAD_REQUEST, "Bazada bu aktiv Employee id - {id} artıq mövcuddur"),

    //Person
    PIN_ALREADY_EXIST("PIN_ALREADY_EXIST", HttpStatus.CONFLICT, "Bazada bu fin {pin} mövcuddur!"),

    // Employee Code
    CODE_DUPLICATE("CODE_ALREADY_EXIST", HttpStatus.CONFLICT, "Bazada bu id {id} ile aktiv kod mövcuddur!"),
    CODE_NOT_EQUALS("CODE_NOT_EQUALS", HttpStatus.BAD_REQUEST, "Daxil etdiyiniz mövcud kod '{code}' bazada olan mövcud kod ilə uzlaşmır!"),
    CODE_EQUALS("CODE_EQUALS", HttpStatus.CONFLICT, "Daxil etdiyiniz yeni kod '{code}' bazada mövcuddur, fərqli kod cəhd edin!");


    final String key;
    final HttpStatus httpStatus;
    final String message;

    ErrorFinals(String key, HttpStatus httpStatus, String message) {
        this.key = key;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}