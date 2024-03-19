import { $authhost } from ".";

export const doPayment = async()=>{
    const {data} = await $authhost.post('store/HookahMafia/basket')  
    return data;
}