import { $authhost,$host } from ".";
import {jwtDecode} from "jwt-decode";

export const createType = async(type)=>{
    const {data} = await $authhost.post('store/HookahMafia/type',type)   
    return data
}

export const fetchType = async()=>{
    const {data} = await $host.get('store/HookahMafia/type')

    return data
}

export const createBrand = async(brand)=>{
    const {data} = await $authhost.post('store/HookahMafia/brand',brand)   
    return data
}

export const fetchBrand = async()=>{
    const {data} = await  $authhost.get('store/HookahMafia/brand')

    return data
}


export const createProduct= async(product)=>{
    const {data} = await $authhost.post('store/HookahMafia/product',product)   
    return data
}

export const fetchProduct = async(type_id,brand_id)=>{
    const {data} = await  $authhost.get('store/HookahMafia/product',{params:{type_id:type_id, brand_id:brand_id}})

    return data
}

export const fetchOneProduct = async(id)=>{
    const {data} = await  $authhost.get('store/HookahMafia/product',{params:{id:id}})

    return data
}