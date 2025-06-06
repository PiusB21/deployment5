<template>
        <div
      class="backdrop-blur-md bg-blue-300/4 !border border-blue-400/20 rounded-md px-6 py-8 shadow-xl text-white w-full mx-auto flex flex-col gap-8"
    >
      <div class="w-full flex justify-between">
        <div>
          <h2 class="text-2xl font-semibold mb-2">Network Monitor</h2>
          <p class="text-sm">Real-time infrastructure monitoring</p>  
        </div>
        
        <p class="text-sm">Last Checked: {{  formatReadableDateTime(targetStatusData[1]?.checkedAt)}}</p>

      </div>
      <div class="grid grid-cols-4 gap-8">
        <div
          class="backdrop-blur-md bg-white/5 !border border-white/20 rounded-md !p-6 shadow-xl text-white w-full mx-auto"
        >
          <div class="w-full">
            <h2 class="text-md text-gray-300 mb-2 flex items-center gap-3">
              <v-icon color="gray" icon="mdi-desktop-classic"></v-icon>
              <span>Total nodes</span>
            </h2>
            <p class="text-3xl font-semibold text-white">{{ targetData.length }}</p>
          </div>
        </div>
        <div
          class="backdrop-blur-md bg-[var(--mygreen)]/5 !border border-[var(--mygreen)]/20 rounded-md !p-6 shadow-xl text-white w-full mx-auto"
        >
          <div class="w-full">
            <h2 class="text-md text-gray-300 mb-2 flex items-center gap-3">
              <div class="w-3 h-3 rounded-full bg-[var(--mygreen)]"></div>
              <span>Healthy</span>
            </h2>
            <p class="text-3xl font-semibold text-[var(--mygreen)]">{{ generalData.healthy }}</p>
          </div>
        </div>

        <div
          class="backdrop-blur-md bg-[var(--myyellow)]/5 !border border-[var(--myyellow)]/20 rounded-md !p-6 shadow-xl text-white w-full mx-auto"
        >
          <div class="w-full">
            <h2 class="text-md text-gray-300 mb-2 flex items-center gap-3">
              <div class="w-3 h-3 rounded-full bg-[var(--myyellow)]"></div>
              <span>Warning</span>
            </h2>
            <p class="text-3xl font-semibold text-[var(--myyellow)]">{{ generalData.warning }}</p>
          </div>
        </div>

        <div
          class="backdrop-blur-md bg-[var(--myred)]/5 !border border-[var(--myred)]/20 rounded-md !p-6 shadow-xl text-white w-full mx-auto"
        >
          <div class="w-full">
            <h2 class="text-md text-gray-300 mb-2 flex items-center gap-3">
              <div class="w-3 h-3 rounded-full bg-[var(--myred)]"></div>
              <span>Critical</span>
            </h2>
            <p class="text-3xl font-semibold text-[var(--myred)]">{{ generalData.critical }}</p>
          </div>
        </div>
      </div>
    </div>

    <div class="w-full grid grid-cols-4 gap-4 my-16">
      <div
        v-for="node in targetStatusData"
        :key="node"
        class="backdrop-blur-md bg-blue-300/4 !border border-blue-400/20 hover:border-blue-400/30 transition-all duration-300 ease-in-out rounded-md !p-6 shadow-xl text-white min-w-full w-fit mx-auto"
      >
        <div class="min-w-full w-fit flex flex-col">
          <h2 class="text-md text-white mb-1 flex items-center gap-3">
            <div
              :class="[
                getStatusLabel(node.httpStatusCode) == 'warning' ? 'bg-[var(--myyellow)]' : '',
                getStatusLabel(node.httpStatusCode) == 'critical' ? 'bg-[var(--myred)]' : '',
                getStatusLabel(node.httpStatusCode) == 'healthy' ? 'bg-[var(--mygreen)]' : '',
              ]"
              class="w-3 h-3 rounded-full"
            ></div>
            <span>{{ node?.target?.name }}</span>
          </h2>
          <p class="text-sm text-gray-300 w-fit">{{ node?.target.url }}</p>
          <div
            :class="[
              node.httpStatusCode>=300 && node.httpStatusCode<=399
                ? 'border-[var(--myyellow)] bg-[var(--myyellow)]/15 text-[var(--myyellow)]'
                : '',
              node.httpStatusCode>=400 && node.httpStatusCode<=599
                ? 'border-[var(--myred)] bg-[var(--myred)]/15 text-[var(--myred)]'
                : '',
              node.httpStatusCode>=200 && node.httpStatusCode<=299
                ? 'border-[var(--mygreen)] bg-[var(--mygreen)]/15 text-[var(--mygreen)]'
                : '',
            ]"
            class="px-4 py-1 rounded-full !border w-fit text-sm font-semibold my-2"
          >
            {{ getStatusLabel(node.httpStatusCode) }}
          </div>
          <div class="grid grid-cols-2 gap-4 my-4">
            <div class="flex flex-col bg-blue-300/4 rounded-lg px-4 py-5">
              <h2 class="text-sm text-gray-300 mb-1 flex items-center gap-2">
                <v-icon color="#05b8cd" icon="mdi-chart-line-variant"></v-icon>
                <span>Latency</span>
              </h2>
              <div class="text-white text-xl font-semibold">{{ node.latency }}ms</div>
            </div>
            <div class="flex flex-col bg-blue-300/4 rounded-lg px-4 py-5">
              <h2 class="text-sm text-gray-300 mb-1 flex items-center gap-2">
                <v-icon color="#7e3e9e" icon="mdi-shield-outline"></v-icon>
                <span>SSL</span>
              </h2>
              <div class="text-[var(--mygreen)] text-xl font-semibold">{{ node.ssl }}</div>
            </div>
          </div>
          <div class="flex flex-col bg-blue-300/4 rounded-lg px-4 py-5">
            <h2 class="text-sm text-gray-300 mb-1 flex items-center gap-2">
              <v-icon color="var(--mygreen)" icon="mdi-clock-outline"></v-icon>
              <span>Uptime (24h)</span>
            </h2>
            <div class="text-white text-xl font-semibold">{{ node.uptime }}</div>
          </div>
        </div>
      </div>
    </div>
</template>

<script setup>
import { onMounted, ref } from 'vue'
import axios from "axios"
import { useRoute } from 'vue-router'

const generalData = ref({
  healthy: 0,
  warning: 0,
  critical: 0,
})

  // {
  //   nodeName: 'Frontend 4',
  //   status: 'healthy',
  //   latency: '45ms',
  //   ssl: '44 days',
  //   uptime: '97.49%',
  //   endpoint: '172.12.12.23:8003',
  // },
const route = useRoute()
const targetData = ref([])
const targetStatusData = ref([])

const getTargetsCountByStatus = ()=>{
   for(const key of Object.keys(targetStatusData.value)){
      let targetStatus =  targetStatusData.value[key]

      console.log(targetStatus.httpStatusCode, "status mate");

      if(getStatusLabel(targetStatus.httpStatusCode) == 'warning') generalData.value.warning++
      if(getStatusLabel(targetStatus.httpStatusCode) == 'healthy') generalData.value.healthy++
      if(getStatusLabel(targetStatus.httpStatusCode) == 'critical') generalData.value.critical++
   }
}


const getStatusLabel = (httpStatusCode)=>{
  
  if(httpStatusCode>=300 && httpStatusCode<=399) return 'warning'

  if(httpStatusCode>=400 && httpStatusCode<=599) return "critical"

  if(httpStatusCode>=200 && httpStatusCode<=299) return "healthy"

}

const getTargetData = async()=>{  
  await axios.get(import.meta.env.VITE_APP_BASE_URL + "/target/all")
  .then((res)=>{
    console.log(res);
  
    if(res?.status!=200){
      console.error("Failed to Load Node Data")
      return
    }
    else {
      targetData.value = res.data
    }
  })
}

const getStatusForTargets = async()=>{
  await axios.get(import.meta.env.VITE_APP_BASE_URL + "/status/all")
  .then((res)=>{
    if(res?.status!=200){
      console.error("Failed to Status Data")
      return
    }
    else {
      targetStatusData.value = res.data
    }
  }).catch((err)=>{
    console.error(err.message)
  })
}

const getStatusForTarget = async(id)=>{
  await axios.get(import.meta.env.VITE_APP_BASE_URL + `/status/all/${id}`)
  .then((res)=>{
    if(res?.status!=200){
      console.error("Failed to Status Data")
      return
    }
    else {
      targetData.value = res.data
    }
  })  
}


function formatReadableDateTime(isoString) {
  const date = new Date(isoString);

  if (isNaN(date)) return "Invalid date";

  const options = {
    year: "numeric",
    month: "long",   // e.g., June
    day: "numeric",
    hour: "2-digit",
    minute: "2-digit",
    second: "2-digit",
  };

  return date.toLocaleString(undefined, options);
}

onMounted(async()=>{
  await getTargetData()
  await getStatusForTargets()
  getTargetsCountByStatus()
})
</script>