<template>
  <a-layout class="basic-layout">
    <!-- 头部导航 -->
    <GlobalHeader />
    
    <!-- 内容区域 -->
    <a-layout-content class="content-area">
      <router-view />
    </a-layout-content>
    
    <!-- 底部版权信息 -->
    <GlobalFooter />
  </a-layout>
</template>

<script setup lang="ts">
import { Layout } from 'ant-design-vue'
import GlobalHeader from '../components/GlobalHeader.vue'
import GlobalFooter from '../components/GlobalFooter.vue'
const { Content } = Layout
</script>

<style scoped>
.basic-layout {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
}

.content-area {
  flex: 1;
  padding: 24px;
  background: #fff;
  width: 100%;
  box-sizing: border-box;
}

/* 平板设备响应式设计 */
@media (max-width: 1024px) {
  .content-area {
    padding: 20px;
  }
}

/* 移动设备响应式设计 */
@media (max-width: 768px) {
  .content-area {
    padding: 16px;
  }
}

/* 小型移动设备响应式设计 */
@media (max-width: 480px) {
  .content-area {
    padding: 12px;
  }
}
</style>