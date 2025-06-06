<template>
  <div class="h-screen w-full bg-[var(--pri)] flex flex-col items-center !p-8 font-sans">

    <div class="flex w-full gap-2 py-3 text-lg text-white font-semibold">
      <router-link class="border-b-2 border-transparent hover:!bg-gray-50/10 px-2 py-1 rounded-t" active-class="!border-blue-400 text-blue-400" :to="{name:'Monitor'}">Monitor</router-link>
      <router-link class="border-b-2 border-transparent hover:!bg-gray-50/10 px-2 py-1 rounded-t" active-class="!border-blue-400 text-blue-400" :to="{name:'Data Endpoints'}">Data Endpoints</router-link>
    </div>

    <router-view/>

  </div>
</template>


