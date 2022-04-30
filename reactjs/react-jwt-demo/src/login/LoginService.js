import axios from "axios";

const URL='http://localhost:5000';
	class AirlineService
	{
		login(authRequest)
		{
			return axios.post(URL+"/authenticate",authRequest);
		}

        hi()
        {
           var token="Bearer "+localStorage.getItem("jwt");
            
            return axios.get(URL+"/hi",{ headers: {"Authorization" : `${token}`} });
        }
	}
	export default new AirlineService;