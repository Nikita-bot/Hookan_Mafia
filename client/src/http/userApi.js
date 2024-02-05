import { $authhost,$host } from ".";
import {jwtDecode} from "jwt-decode";

export const registration = async(phone, password, name)=>{
    const {data} = await $host.post('store/HookahMafia/user/reg',{phone,password,name})
    console.log(data)
    localStorage.setItem('token', data)    
    return jwtDecode(data)
}

export const login = async(phone, password)=>{
    const {data} = await $host.get('store/HookahMafia/user/login',{params:{phone:phone,pass: password}})
    console.log(data)
    localStorage.setItem('token', data)
    return jwtDecode(data)
}


export const check = async()=>{
    const {data} = await $authhost.get('store/HookahMafia/user/auth')
    
    localStorage.setItem('token', data)
    return jwtDecode(data)
}