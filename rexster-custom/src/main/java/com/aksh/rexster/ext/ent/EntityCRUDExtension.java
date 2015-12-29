package com.aksh.rexster.ext.ent;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.rexster.RexsterResourceContext;
import com.tinkerpop.rexster.extension.AbstractRexsterExtension;
import com.tinkerpop.rexster.extension.ExtensionDefinition;
import com.tinkerpop.rexster.extension.ExtensionDescriptor;
import com.tinkerpop.rexster.extension.ExtensionMethod;
import com.tinkerpop.rexster.extension.ExtensionNaming;
import com.tinkerpop.rexster.extension.ExtensionPoint;
import com.tinkerpop.rexster.extension.ExtensionRequestParameter;
import com.tinkerpop.rexster.extension.ExtensionResponse;
import com.tinkerpop.rexster.extension.HttpMethod;
import com.tinkerpop.rexster.extension.RexsterContext;

/**
 * A simple extension that just echoes back the string parameter passed in, but
 * further demonstrates that an extension class can share a name within the same
 * namespace with another class (in this case the standard PingExtension). In
 * other words, extensions can span multiple classes within the same namespace
 * and name.
 */
@ExtensionNaming(namespace = "rex", name = "crud")
public class EntityCRUDExtension extends AbstractRexsterExtension {

	/**
	 * GET http://<server>:<port>/graphs/<graph-name>/rex/crud/entity?reply=test
	 */
	@ExtensionDefinition(extensionPoint = ExtensionPoint.GRAPH, path = "ping", method = HttpMethod.GET)
	@ExtensionDescriptor(description = "a simple ping extension.")
	public ExtensionResponse ping(@RexsterContext RexsterResourceContext context, @RexsterContext Graph graph,
			@ExtensionRequestParameter(name = "reply", description = "a value to reply with") String reply) {
		if (reply == null || reply.isEmpty()) {
			ExtensionMethod extMethod = context.getExtensionMethod();
			return ExtensionResponse.error("the reply parameter cannot be empty", null,
					Response.Status.BAD_REQUEST.getStatusCode(), null,
					generateErrorJson(extMethod.getExtensionApiAsJson()));
		}

		Map<String, String> map = new HashMap<String, String>();
		map.put("response", reply);
		return ExtensionResponse.ok(map);
	}

	/**
	 * GET http://<server>:<port>/graphs/<graph-name>/rex/crud/entity?reply=test
	 * 
	 * @throws JSONException
	 */
	@ExtensionDefinition(extensionPoint = ExtensionPoint.GRAPH, path = "entity")
	@ExtensionDescriptor(description = "a simple ping extension.")
	public ExtensionResponse postEntity(@RexsterContext RexsterResourceContext context, @RexsterContext Graph graph) throws JSONException{
			//,@ExtensionRequestParameter(name = "param", description = "A parameter",defaultValue = "{ \"emailId\":\"arawat@sapient.com\",\"name\":\"Akshaya\" }") JSONObject param) throws JSONException {
		System.err.println("I am in ");
		return ExtensionResponse.ok(new JSONObject().put("reponse", "OK POST"));
	}
}
