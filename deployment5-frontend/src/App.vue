<template>
  <div class="h-screen w-full bg-[var(--pri)] flex flex-col items-center !p-8 font-sans">
    <div class="w-full flex items-center justify-between">
      <div class="flex w-full gap-2 py-3 text-lg text-white font-semibold">
        <router-link class="border-b-2 border-transparent hover:!bg-gray-50/10 px-2 py-1 rounded-t" active-class="!border-blue-400 text-blue-400" :to="{name:'Monitor'}">Monitor</router-link>
        <router-link class="border-b-2 border-transparent hover:!bg-gray-50/10 px-2 py-1 rounded-t" active-class="!border-blue-400 text-blue-400" :to="{name:'Data Endpoints'}">Data Endpoints</router-link>
      </div>
      <div class="text-md text-white flex text-nowrap">
          Running node :&nbsp;<span class="text-blue-400 ">{{ nodeId }}</span>
      </div>
    </div>  

    <router-view/>

  </div>
</template>


<script setup>
import { onMounted,ref } from 'vue';
import axios from "axios"

const nodeId = ref('')

const fetchId = async()=>{
  await axios.get("/config.json").then(res => {
    nodeId.value = res.data.VITE_APP_NODE_ID;
  })
} 

onMounted(async()=>{
  await fetchId()
})

</script>

