package api.endpoints;
/*swagger uri: https://www.petstore.swagger.io
 * create user(POST)-https://www.petstore.swagger.io/v2/user
 * get user (GET)-https://www.petstore.swagger.io/v2/user/{username}
 * update user(PUT)-https://www.petstore.swagger.io/v2/user/{username}
 * delete user(DELETE)-https://www.petstore.swagger.io/v2/user/{username}
 */
public class Routes
{
	public static String base_url="https://petstore.swagger.io/v2";

	//user module
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String update_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	
	//Store module
	
	//pet module
}
