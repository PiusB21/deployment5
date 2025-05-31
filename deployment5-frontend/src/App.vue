<template>
  <div class="h-screen w-full bg-[var(--pri)] flex flex-col items-center !p-8 font-sans">
    <div
      class="backdrop-blur-md bg-blue-300/4 !border border-blue-400/20 rounded-md px-6 py-8 shadow-xl text-white w-full mx-auto flex flex-col gap-8"
    >
      <div class="w-full">
        <h2 class="text-2xl font-semibold mb-2">Network Monitor</h2>
        <p class="text-sm">Real-time infrastructure monitoring</p>
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
            <p class="text-3xl font-semibold text-white">{{ generalData.totalNodes }}</p>
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
        v-for="node in nodesData"
        :key="node"
        class="backdrop-blur-md bg-blue-300/4 !border border-blue-400/20 hover:border-blue-400/30 transition-all duration-300 ease-in-out rounded-md !p-6 shadow-xl text-white w-full mx-auto"
      >
        <div class="w-full flex flex-col">
          <h2 class="text-md text-white mb-1 flex items-center gap-3">
            <div
              :class="[
                node.status == 'warning' ? 'bg-[var(--myyellow)]' : '',
                node.status == 'critical' ? 'bg-[var(--myred)]' : '',
                node.status == 'healthy' ? 'bg-[var(--mygreen)]' : '',
              ]"
              class="w-3 h-3 rounded-full"
            ></div>
            <span>{{ node.nodeName }}</span>
          </h2>
          <p class="text-sm text-gray-300">{{ node.endpoint }}</p>
          <div
            :class="[
              node.status == 'warning'
                ? 'border-[var(--myyellow)] bg-[var(--myyellow)]/15 text-[var(--myyellow)]'
                : '',
              node.status == 'critical'
                ? 'border-[var(--myred)] bg-[var(--myred)]/15 text-[var(--myred)]'
                : '',
              node.status == 'healthy'
                ? 'border-[var(--mygreen)] bg-[var(--mygreen)]/15 text-[var(--mygreen)]'
                : '',
            ]"
            class="px-4 py-1 rounded-full !border w-fit text-sm font-semibold my-2"
          >
            {{ node.status }}
          </div>
          <div class="grid grid-cols-2 gap-4 my-4">
            <div class="flex flex-col bg-blue-300/4 rounded-lg px-4 py-5">
              <h2 class="text-sm text-gray-300 mb-1 flex items-center gap-2">
                <v-icon color="#05b8cd" icon="mdi-chart-line-variant"></v-icon>
                <span>Latency</span>
              </h2>
              <div class="text-white text-xl font-semibold">{{ node.latency }}</div>
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
  </div>
</template>

<script setup>
import { ref } from 'vue'

const generalData = {
  totalNodes: 4,
  healthy: 2,
  warning: 1,
  critical: 1,
}

const nodesData = [
  {
    nodeName: 'Frontend 1',
    status: 'warning',
    latency: '45ms',
    ssl: '44 days',
    uptime: '97.49%',
    endpoint: '172.12.12.23:8000',
  },
  {
    nodeName: 'Frontend 2',
    status: 'healthy',
    latency: '45ms',
    ssl: '44 days',
    uptime: '97.49%',
    endpoint: '172.12.12.23:8001',
  },
  {
    nodeName: 'Frontend 3',
    status: 'critical',
    latency: '45ms',
    ssl: '44 days',
    uptime: '97.49%',
    endpoint: '172.12.12.23:8002',
  },
  {
    nodeName: 'Frontend 4',
    status: 'healthy',
    latency: '45ms',
    ssl: '44 days',
    uptime: '97.49%',
    endpoint: '172.12.12.23:8003',
  },
]
</script>
