/**
 *     Copyright (C) 2019-2024 Ubiqube.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.27).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.ubiqube.etsi.mano.v451.nfvo.controller.nfvo.lcmcoord;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ubiqube.etsi.mano.v451.model.em.vnfconfig.ProblemDetails;
import com.ubiqube.etsi.mano.v451.model.nfvo.lcmcoord.LcmCoord;
import com.ubiqube.etsi.mano.v451.model.nfvo.lcmcoord.LcmCoordRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;

@Validated
@RequestMapping(value = "/sol005/lcmcoord/v1", headers = { "Version=1.12.0" })
@RolesAllowed({ "ROLE_OSSBSS" })
public interface Coordinations451Sol005Api {
	@Operation(summary = "", description = "The POST method initiates the cancellation of an ongoing coordination action. See clause 12.4.4.3.1. ", tags = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "202 ACCEPTED  Shall be returned when the cancellation request has been accepted for processing.  The response shall have an empty message content. "),
			@ApiResponse(responseCode = "400", description = "400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \"ProblemDetails\" structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the message content contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If there is an application error related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "401", description = "401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "403", description = "403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided. It should include in the \"detail\" attribute information about the source of the problem, and may indicate how to solve it. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "404", description = "404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \"ProblemDetails\" structure may be provided, including in the \"detail\" attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a message content with an empty array. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "405", description = "405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "406", description = "406 NOT ACCEPTABLE If the \"Accept\" HTTP header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "409", description = "409 CONFLICT ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "416", description = "416 Range Not Satisfiable ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "500", description = "500 INTERNAL SERVER ERROR If there is an application error not related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "503", description = "503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \"Retry-After\" HTTP header and for the alternative to refuse the connection. The \"ProblemDetails\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "504", description = "504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))) })
	@RequestMapping(value = "/coordinations/cancel", produces = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<Void> coordinationsCancelPost(
			@Parameter(in = ParameterIn.HEADER, description = "Version of the API requested to use when responding to this request. ", required = true, schema = @Schema()) @RequestHeader(value = "Version", required = true) final String version,
			@Parameter(in = ParameterIn.HEADER, description = "Content-Types that are acceptable for the response. Reference: IETF RFC 7231. ", required = true, schema = @Schema()) @RequestHeader(value = "Accept", required = true) final String accept,
			@Parameter(in = ParameterIn.HEADER, description = "The authorization token for the request. Reference: IETF RFC 7235. ", schema = @Schema()) @RequestHeader(value = "Authorization", required = false) final String authorization);

	@Operation(summary = "", description = "The GET method reads a coordination result. See clause 12.4.3.3.2. ", tags = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "200 OK  Shall be returned when the coordination is finished and the coordination result  has been read successfully. A representation of the \"Individual coordination action\" resource shall be returned  in the response body. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = LcmCoord.class))),
			@ApiResponse(responseCode = "400", description = "400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \"ProblemDetails\" structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the message content contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If there is an application error related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "401", description = "401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "403", description = "403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided. It should include in the \"detail\" attribute information about the source of the problem, and may indicate how to solve it. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "404", description = "404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \"ProblemDetails\" structure may be provided, including in the \"detail\" attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a message content with an empty array. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "405", description = "405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "406", description = "406 NOT ACCEPTABLE If the \"Accept\" HTTP header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "416", description = "416 Range Not Satisfiable ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "500", description = "500 INTERNAL SERVER ERROR If there is an application error not related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "503", description = "503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \"Retry-After\" HTTP header and for the alternative to refuse the connection. The \"ProblemDetails\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "504", description = "504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))) })
	@RequestMapping(value = "/coordinations/{coordinationId}", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<LcmCoord> coordinationsCoordinationIdGet(
			@Parameter(in = ParameterIn.PATH, description = "Identifier of the LCM coordination.  NOTE: This identifier can be retrieved from the resource referenced by the        \"Location\" HTTP header in the response to a POST request to the        \"Coordinations\" resource. ", required = true, schema = @Schema()) @PathVariable("coordinationId") final String coordinationId);

	@Operation(summary = "", description = "The POST method requests the coordination of an LCM operation occurrence with a management operation executed in the API producer. See clause 12.4.2.3.1. ", tags = {})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "201 CREATED  Shall be returned  to indicate a finished coordination action when the API producer has chosen the synchronous mode, which may be selected for coordination actions that finish within the time frame in which an HTTP response is expected..  The response body shall contain an LcmCoord data structure that represents the result  of the coordination action. The HTTP response shall include a \"Location\" HTTP header that indicates the URI of the  \"Individual coordination action\" resource that has been created as the result of the  finished coordination procedure. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = LcmCoord.class))),
			@ApiResponse(responseCode = "202", description = "202 ACCEPTED  Shall be returned when the API producer has chosen the asynchronous mode and  the request has been accepted for processing.  The response body shall be empty.  The HTTP response shall include a \"Location\" HTTP header that indicates the  URI of the \"Individual coordination action\" resource that will be created  once the coordination operation has finished successfully.  Further, the HTTP response may include a \"Retry-After\" HTTP header that indicates the time to wait before sending the next GET request to the \"individual coordination\" resource indicated in the \"Location\" header. If the header is provided, the NFVO shall record the signalled delay value in the \"delay\" attribute of the applicable entry in the \"lcmCoordinations\" array in the \"NsLcmOpOcc\" structure. "),
			@ApiResponse(responseCode = "400", description = "400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \"ProblemDetails\" structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the message content contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If there is an application error related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "401", description = "401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "403", description = "403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided. It should include in the \"detail\" attribute information about the source of the problem, and may indicate how to solve it. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "404", description = "404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \"ProblemDetails\" structure may be provided, including in the \"detail\" attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a message content with an empty array. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "405", description = "405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "406", description = "406 NOT ACCEPTABLE If the \"Accept\" HTTP header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "409", description = "409 CONFLICT ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "416", description = "416 Range Not Satisfiable ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "500", description = "500 INTERNAL SERVER ERROR If there is an application error not related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "503", description = "503 Service Unavailable  Shall be returned upon the following error: The API producer has chosen the synchronous mode and cannot perform the requested coordination currently, but expects to be able to perform it sometime in the future.  No \"individual coordination action\" resource shall be created.  A ProblemDetails structure shall be included in the response to provide more details about the rejection in the \"details\" attribute.  The HTTP response shall include a \"Retry-After\" HTTP header that indicates the delay after which it is suggested to repeat the coordination request with the same set of parameters. The NFVO shall record the signalled delay value in the \"delay\" attribute of the applicable entry in the \"rejectedLcmCoordinations\" array in the \"NsLcmOpOcc\" structure. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))),
			@ApiResponse(responseCode = "504", description = "504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetails.class))) })
	@RequestMapping(value = "/coordinations", produces = { "application/json" }, consumes = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<LcmCoord> coordinationsPost(
			@Parameter(in = ParameterIn.DEFAULT, description = "Parameters for the coordination action as defined in clause 12.5.2.2.", required = true, schema = @Schema()) @Valid @RequestBody final LcmCoordRequest body);
}
