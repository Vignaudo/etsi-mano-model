/**
 * This copy of Woodstox XML processor is licensed under the
 * Apache (Software) License, version 2.0 ("the License").
 * See the License for details about distribution rights, and the
 * specific rights regarding derivate works.
 *
 * You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/
 *
 * A copy is also included in the downloadable source code package
 * containing Woodstox, in file "ASL2.0", under the same directory
 * as this file.
 */
package com.ubiqube.etsi.mano.nfvo.v261.controller.vnf;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.ubiqube.etsi.mano.common.v261.model.vnf.VnfPkgInfo;
import com.ubiqube.etsi.mano.model.ProblemDetails;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface VnfPackageSol003 {

	/**
	 * Query VNF packages information.
	 *
	 * The GET method queries the information of the VNF packages matching the
	 * filter. This method shall follow the provisions specified in the Tables
	 * 9.4.2.3.2-1 and 9.4.2.3.2-2 for URI query parameters, request and response
	 * data structures, and response codes.
	 *
	 */
	@GetMapping(produces = { "application/json" }, consumes = { "application/json" })
	ResponseEntity<String> vnfPackagesGet(@Nonnull @RequestParam Map<String, String> requestParams);

	/**
	 * Fetch individual VNF package artifact.
	 *
	 * The GET method fetches the content of an artifact within a VNF package. This
	 * method shall follow the provisions specified in the Tables 9.4.7.3.2-1 and
	 * 9.4.7.3.2-2 for URI query parameters, request and response data structures,
	 * and response codes.
	 *
	 */
	@ApiOperation(value = "", nickname = "vnfPackagesVnfPkgIdArtifactsArtifactPathGet", notes = "Fetch VNF Package Artifacts. The GET method fetches the content of an artifact within a VNF package. This method shall follow the provisions specified in the tables 10.4.6.3.2-1 and 10.4.6.3.2-2 for URI query parameters, request and response data structures, and response codes. ", tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "200 OK Shall be returned when the whole content of the artifact file has been read successfully. The payload body shall contain a copy of the artifact file from the VNF package, as defined by ETSI GS NFV-SOL 004. The \"Content-Type\" HTTP header shall be set according to the content type of the artifact file. If the content type cannot be determined, the header shall be set to the value \"application/octet-stream\". "),
			@ApiResponse(code = 206, message = "206 PARTIAL CONTENT If the NFVO supports range requests, this response shall be returned when a single consecutive byte range from the content of the artifact file, if the NFVO supports range requests has been read successfully according to the request. The response body shall contain the requested part of the VNF package file. The \"Content-Range\" HTTP header shall be provided according to IETF RFC 7233. The \"Content-Type\" HTTP header shall be set as defined above for the \"200 OK\" response. "),
			@ApiResponse(code = 400, message = "400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \"ProblemDetails\" structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If there is an application error related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. ", response = ProblemDetails.class),
			@ApiResponse(code = 401, message = "401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. ", response = ProblemDetails.class),
			@ApiResponse(code = 403, message = "403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided. It should include in the \"detail\" attribute information about the source of the problem, and may indicate how to solve it. ", response = ProblemDetails.class),
			@ApiResponse(code = 404, message = "404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \"ProblemDetails\" structure may be provided, including in the \"detail\" attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. ", response = ProblemDetails.class),
			@ApiResponse(code = 405, message = "405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ", response = ProblemDetails.class),
			@ApiResponse(code = 406, message = "406 NOT ACCEPTABLE If the \"Accept\" HTTP header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ", response = ProblemDetails.class),
			@ApiResponse(code = 409, message = "409 CONFLICT ", response = ProblemDetails.class),
			@ApiResponse(code = 416, message = "416 Range Not Satisfiable ", response = ProblemDetails.class),
			@ApiResponse(code = 500, message = "500 INTERNAL SERVER ERROR If there is an application error not related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. ", response = ProblemDetails.class),
			@ApiResponse(code = 503, message = "503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \"Retry-After\" HTTP header and for the alternative to refuse the connection. The \"ProblemDetails\" structure may be omitted. ", response = ProblemDetails.class),
			@ApiResponse(code = 504, message = "504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. ", response = ProblemDetails.class) })
	@GetMapping(value = "/{vnfPkgId}/artifacts/**", produces = { "application/json", "application/zip", "*/*" }, consumes = { "application/json" })
	ResponseEntity<List<ResourceRegion>> vnfPackagesVnfPkgIdArtifactsArtifactPathGet(@Nonnull @PathVariable("vnfPkgId") String vnfPkgId, @Nonnull HttpServletRequest request, @Nullable @RequestHeader(value = "Range", required = false) String range);

	/**
	 * Read information about an individual VNF package.
	 *
	 * The GET method reads the information of a VNF package.
	 *
	 */
	@ApiOperation(value = "", nickname = "vnfPackagesVnfPkgIdGet", notes = "Query VNF Package Info. The GET method reads the information of an individual VNF package. This method shall follow the provisions specified in the tables 10.4.3.3.2-1 and 10.4.3.3.2-2 for URI query parameters, request and response data structures, and response codes. ", response = VnfPkgInfo.class, tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "200 OK Shall be returned when information of the VNF package has been read successfully. The response body shall contain the VNF package info representation defined in clause 10.5.2.2. ", response = VnfPkgInfo.class),
			@ApiResponse(code = 400, message = "400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \"ProblemDetails\" structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If there is an application error related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. ", response = ProblemDetails.class),
			@ApiResponse(code = 401, message = "401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. ", response = ProblemDetails.class),
			@ApiResponse(code = 403, message = "403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided. It should include in the \"detail\" attribute information about the source of the problem, and may indicate how to solve it. ", response = ProblemDetails.class),
			@ApiResponse(code = 404, message = "404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \"ProblemDetails\" structure may be provided, including in the \"detail\" attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. ", response = ProblemDetails.class),
			@ApiResponse(code = 405, message = "405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ", response = ProblemDetails.class),
			@ApiResponse(code = 406, message = "406 NOT ACCEPTABLE If the \"Accept\" HTTP header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ", response = ProblemDetails.class),
			@ApiResponse(code = 416, message = "416 Range Not Satisfiable ", response = ProblemDetails.class),
			@ApiResponse(code = 500, message = "500 INTERNAL SERVER ERROR If there is an application error not related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. ", response = ProblemDetails.class),
			@ApiResponse(code = 503, message = "503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \"Retry-After\" HTTP header and for the alternative to refuse the connection. The \"ProblemDetails\" structure may be omitted. ", response = ProblemDetails.class),
			@ApiResponse(code = 504, message = "504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. ", response = ProblemDetails.class) })
	@GetMapping(value = "/{vnfPkgId}", produces = { "application/json" }, consumes = { "application/json" })
	ResponseEntity<VnfPkgInfo> vnfPackagesVnfPkgIdGet(@Nonnull @PathVariable("vnfPkgId") String vnfPkgId);

	/**
	 * Fetch an on-boarded VNF package.
	 *
	 * The GET method fetches the content of a VNF package identified by the VNF
	 * package identifier allocated by the NFVO. This method shall follow the
	 * provisions specified in the Tables 9.4.5.3.2-1 and 9.4.5.3.2-2 for URI query
	 * parameters, request and response data structures, and response codes.
	 *
	 * @throws IOException
	 *
	 */
	@ApiOperation(value = "", nickname = "vnfPackagesVnfPkgIdPackageContentGet", notes = "Fetch VNF Package. The GET method fetches the content of a VNF package identified by the VNF package identifier allocated by the NFVO. This method shall follow the provisions specified in the tables 10.4.5.3.2-1 and 10.4.5.3.2-2 for URI query parameters, request and response data structures, and response codes. ", tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "200 OK Shall be returned when the whole content of the VNF package file has been read successfully. The response body shall include a copy of the VNF package file. The \"Content-Type HTTP\" header shall be set according to the type of the file, i.e. to \"application/zip\" for a VNF Package as defined in ETSI GS  NFV SOL  004. "),
			@ApiResponse(code = 206, message = "206 PARTIAL CONTENT If the NFVO supports range requests, this response shall be returned when a single consecutive byte range from the content of the VNF package file has been read successfully according to the request. The response body shall contain the requested part of the VNF package file. The \"Content-Range\" HTTP header shall be provided according to IETF RFC 7233. The \"Content-Type\" HTTP header shall be set as defined above for the \"200 OK\" response. "),
			@ApiResponse(code = 400, message = "400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \"ProblemDetails\" structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If there is an application error related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. ", response = ProblemDetails.class),
			@ApiResponse(code = 401, message = "401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. ", response = ProblemDetails.class),
			@ApiResponse(code = 403, message = "403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided. It should include in the \"detail\" attribute information about the source of the problem, and may indicate how to solve it. ", response = ProblemDetails.class),
			@ApiResponse(code = 404, message = "404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \"ProblemDetails\" structure may be provided, including in the \"detail\" attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. ", response = ProblemDetails.class),
			@ApiResponse(code = 405, message = "405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ", response = ProblemDetails.class),
			@ApiResponse(code = 406, message = "406 NOT ACCEPTABLE If the \"Accept\" HTTP header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ", response = ProblemDetails.class),
			@ApiResponse(code = 409, message = "409 CONFLICT ", response = ProblemDetails.class),
			@ApiResponse(code = 416, message = "416 Range Not Satisfiable ", response = ProblemDetails.class),
			@ApiResponse(code = 500, message = "500 INTERNAL SERVER ERROR If there is an application error not related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. ", response = ProblemDetails.class),
			@ApiResponse(code = 503, message = "503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \"Retry-After\" HTTP header and for the alternative to refuse the connection. The \"ProblemDetails\" structure may be omitted. ", response = ProblemDetails.class),
			@ApiResponse(code = 504, message = "504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. ", response = ProblemDetails.class) })
	@GetMapping(value = "/{vnfPkgId}/package_content", produces = { "application/json" }, consumes = { "application/json" })
	ResponseEntity<List<ResourceRegion>> vnfPackagesVnfPkgIdPackageContentGet(@Nonnull @PathVariable("vnfPkgId") String vnfPkgId, @Nullable @RequestHeader(value = "Range", required = false) String range);

	/**
	 * Read VNFD of an on-boarded VNF package.
	 *
	 * The GET method reads the content of the VNFD within a VNF package. The VNFD
	 * can be implemented as a single file or as a collection of multiple files. If
	 * the VNFD is implemented in the form of multiple files, a ZIP file embedding
	 * these files shall be returned. If the VNFD is implemented as a single file,
	 * either that file or a ZIP file embedding that file shall be returned. The
	 * selection of the format is controlled by the \&quot;Accept\&quot; HTTP header
	 * passed in the GET request. • If the \&quot;Accept\&quot; header contains only
	 * \&quot;text/plain\&quot; and the VNFD is implemented as a single file, the
	 * file shall be returned; otherwise, an error message shall be returned. • If
	 * the \&quot;Accept\&quot; header contains only \&quot;application/zip\&quot;,
	 * the single file or the multiple files that make up the VNFD shall be returned
	 * embedded in a ZIP file. • If the \&quot;Accept\&quot; header contains both
	 * \&quot;text/plain\&quot; and \&quot;application/zip\&quot;, it is up to the
	 * NFVO to choose the format to return for a single-file VNFD; for a multi-file
	 * VNFD, a ZIP file shall be returned. The default format of the ZIP file shall
	 * be the one specified in ETSI GS NFV-SOL 004 [5] where only the YAML files
	 * representing the VNFD, and information necessary to navigate the ZIP file and
	 * to identify the file that is the entry point for parsing the VNFD (such as
	 * TOSCA-meta or manifest files or naming conventions) are included. This method
	 * shall follow the provisions specified in the Tables 9.4.4.3.2-1 and
	 * 9.4.4.3.2-2 for URI query parameters, request and response data structures,
	 * and response codes.
	 *
	 */
	@ApiOperation(value = "", nickname = "vnfPackagesVnfPkgIdVnfdGet", notes = "Query VNF Package Info  The GET method reads the content of the VNFD within a VNF package. The VNFD can be implemented as a single file or as a collection of multiple files. If the VNFD is implemented in the form of multiple files, a ZIP file embedding these files shall be returned. If the VNFD is implemented as a single file, either that file or a ZIP file embedding that file shall be returned. The selection of the format is controlled by the \"Accept\" HTTP header passed in the GET request. * If the \"Accept\" header contains only \"text/plain\" and the VNFD is   implemented as a single file, the file shall be returned;   otherwise, an error message shall be returned. * If the \"Accept\" header contains only \"application/zip\", the single   file or the multiple files that make up the VNFD shall be returned   embedded in a ZIP file. * If the \"Accept\" header contains both \"text/plain\" and   \"application/zip\", it is up to the NFVO to choose the format to   return for a single-file VNFD; for a multi-file VNFD, a ZIP file   shall be returned. The default format of the ZIP file shall be the one specified in ETSI GS NFV-SOL 004 where only the YAML files representing the VNFD, and information needed to navigate the ZIP file and to identify the file that is the entry point for parsing the VNFD (such as TOSCA-meta or manifest files or naming conventions) are included. ", tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "200 OK Shall be returned when the content of the VNFD has been read successfully. The payload body shall contain a copy of the file representing the VNFD or a ZIP file that contains the file or multiple files representing the VNFD, as specified above. The \"Content-Type\" HTTP header shall be set according to the format of the returned file, i.e. to \"text/plain\" for a YAML file or to \"application/zip\" for a ZIP file. "),
			@ApiResponse(code = 400, message = "400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \"ProblemDetails\" structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and should include in the \"detail\" attribute more information about the source of the problem. If there is an application error related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. ", response = ProblemDetails.class),
			@ApiResponse(code = 401, message = "401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. ", response = ProblemDetails.class),
			@ApiResponse(code = 403, message = "403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided. It should include in the \"detail\" attribute information about the source of the problem, and may indicate how to solve it. ", response = ProblemDetails.class),
			@ApiResponse(code = 404, message = "404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \"ProblemDetails\" structure may be provided, including in the \"detail\" attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. ", response = ProblemDetails.class),
			@ApiResponse(code = 405, message = "405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ", response = ProblemDetails.class),
			@ApiResponse(code = 406, message = "406 NOT ACCEPTABLE If the \"Accept\" HTTP header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \"ProblemDetails\" structure may be omitted. ", response = ProblemDetails.class),
			@ApiResponse(code = 409, message = "409 CONFLICT ", response = ProblemDetails.class),
			@ApiResponse(code = 416, message = "416 Range Not Satisfiable ", response = ProblemDetails.class),
			@ApiResponse(code = 500, message = "500 INTERNAL SERVER ERROR If there is an application error not related to the client's input that cannot be easily mapped to any other HTTP response code (\"catch all error\"), the API producer shall respond with this response code. The \"ProblemDetails\" structure shall be provided, and shall include in the \"detail\" attribute more information about the source of the problem. ", response = ProblemDetails.class),
			@ApiResponse(code = 503, message = "503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \"Retry-After\" HTTP header and for the alternative to refuse the connection. The \"ProblemDetails\" structure may be omitted. ", response = ProblemDetails.class),
			@ApiResponse(code = 504, message = "504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. ", response = ProblemDetails.class) })
	@GetMapping(value = "/{vnfPkgId}/vnfd", produces = { "text/plain", "application/json", "application/octet-stream", "application/zip" }, consumes = { "application/json" })
	ResponseEntity<Resource> vnfPackagesVnfPkgIdVnfdGet(@Nonnull @PathVariable("vnfPkgId") String vnfPkgId, final String accept);

}