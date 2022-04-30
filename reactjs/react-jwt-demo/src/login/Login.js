import React, { Component } from "react";
import LoginService from "./LoginService";

export default class Login extends React.Component
{
    constructor()
    {
        super();
        this.state={"username":'',"password":''};
        this.fnSubmit=this.fnSubmit.bind(this);
        this.fnHi=this.fnHi.bind(this);
    }

    // fnSetUsername(username)
    // {
    //     console.log(username);
    //     this.setState({"username":username});
    //     console.log("state is "+this.state.username);
    // }

    fnSubmit()
    {
        
        console.log(this.state)
        LoginService.login(this.state).then((response)=>{
            console.log(response);
            console.log(response.data.jwt);
            console.log("Storing jwt in localStorage");
            localStorage.setItem("jwt",response.data.jwt);
        },(error)=>{
            console.log(error)
        });
    }

    fnHi()
    {
        console.log('going to call')
        LoginService.hi().then((response)=>{
        console.log(response);
        console.log(response.data.str);
        });
    }

    render()
    {
        return <div>
            {this.state.username} | {this.state.password}
            <form>
                User Name: <input type="text" onChange={(event)=>this.setState({"username":event.target.value})} /><br/>
                Password: <input type="password" onChange={(event)=>this.setState({"password":event.target.value})} /><br/>
                <input type="button" value="Login" onClick={this.fnSubmit} />
            </form>
            <br/>
            <br/>

            <input type="button" value="Call hi method" onClick={this.fnHi} />
        </div>;
    }
}