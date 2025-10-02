<template>
  <a-layout-header class="header">
    <div class="header-content">
      <!-- Logo 和标题 -->
      <div class="logo-title-container">
        <div class="logo">
          <span class="logo-text">AI</span>
        </div>
        <h1 class="site-title">AI 零代码平台</h1>
      </div>
      
      <!-- 导航菜单 - 桌面版 -->
      <div class="nav-container">
        <a-menu
          mode="horizontal"
          :selectedKeys="[currentPath]"
          @select="handleMenuSelect"
          class="header-menu"
          :theme="'light'"
        >
          <a-menu-item key="/">首页</a-menu-item>
          <a-menu-item key="/about">关于我们</a-menu-item>
        </a-menu>
      </div>
      
      <!-- 操作区域 -->
      <div class="actions-container">
        <a-button type="primary" size="middle">登录</a-button>
        
        <!-- 移动端菜单按钮 -->
        <a-button 
          type="text" 
          class="mobile-menu-btn"
          @click="toggleMobileMenu"
        >
          <MenuOutlined />
        </a-button>
      </div>
    </div>
    
    <!-- 移动端侧边菜单 -->
    <a-drawer
      placement="left"
      :open="mobileMenuOpen"
      @close="closeMobileMenu"
      class="mobile-menu-drawer"
    >
      <div class="drawer-header">
        <div class="logo">
          <span class="logo-text">AI</span>
        </div>
        <span class="drawer-title">AI 零代码平台</span>
      </div>
      <a-menu
        mode="inline"
        :selectedKeys="[currentPath]"
        @select="handleMobileMenuSelect"
        class="mobile-menu"
        style="border-right: none; margin-top: 20px;"
      >
        <a-menu-item key="/">首页</a-menu-item>
        <a-menu-item key="/about">关于我们</a-menu-item>
      </a-menu>
    </a-drawer>
  </a-layout-header>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'
import { Layout, Menu, Button, Drawer } from 'ant-design-vue'
import { MenuOutlined } from '@ant-design/icons-vue'

const router = useRouter()
const currentPath = ref('')
const mobileMenuOpen = ref(false)

// 获取当前路由路径
onMounted(() => {
  currentPath.value = router.currentRoute.value.path
  
  // 监听路由变化
  router.afterEach((to) => {
    currentPath.value = to.path
  })
})

// 处理菜单选择
const handleMenuSelect = ({ key }: { key: string }) => {
  router.push(key)
}

// 切换移动端菜单
const toggleMobileMenu = () => {
  mobileMenuOpen.value = !mobileMenuOpen.value
}

// 关闭移动端菜单
const closeMobileMenu = () => {
  mobileMenuOpen.value = false
}

// 处理移动端菜单选择
const handleMobileMenuSelect = ({ key }: { key: string }) => {
  router.push(key)
  closeMobileMenu()
}
</script>

<style scoped>
.header {
  background: #fff;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  height: 64px;
  position: sticky;
  top: 0;
  z-index: 10;
}

.header-content {
  display: flex;
  align-items: center;
  justify-content: space-between;
  height: 100%;
  max-width: 1400px;
  margin: 0 auto;
  padding: 0 24px;
  width: 100%;
  box-sizing: border-box;
}

/* Logo 和标题容器 */
.logo-title-container {
  display: flex;
  align-items: center;
  gap: 12px;
  flex-shrink: 0;
}

.logo {
  width: 40px;
  height: 40px;
  background: #1890ff;
  border-radius: 8px;
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
  font-weight: bold;
  font-size: 18px;
}

.logo-text {
  color: white;
  font-weight: bold;
  font-size: 18px;
}

.site-title {
  font-size: 18px;
  margin: 0;
  font-weight: 600;
  color: #262626;
  white-space: nowrap;
}

/* 导航容器 */
.nav-container {
  flex: 1;
  display: flex;
  justify-content: center;
  margin: 0 24px;
}

.header-menu {
  border-bottom: none;
  background: transparent;
}

/* 操作容器 */
.actions-container {
  display: flex;
  align-items: center;
  gap: 12px;
  flex-shrink: 0;
}

/* 移动端菜单按钮 */
.mobile-menu-btn {
  display: none;
  font-size: 18px;
  padding: 8px;
}

/* 移动端侧边菜单样式 */
.drawer-header {
  display: flex;
  align-items: center;
  gap: 12px;
  padding: 16px 24px;
  border-bottom: 1px solid #f0f0f0;
}

.drawer-title {
  font-size: 18px;
  font-weight: 600;
  color: #262626;
}

.mobile-menu {
  padding: 16px 0;
}

/* 响应式设计 - 平板和桌面端 */
@media (min-width: 1025px) {
  .header-content {
    padding: 0 32px;
  }
}

/* 响应式设计 - 平板端 */
@media (max-width: 1024px) {
  .header-content {
    padding: 0 24px;
  }
  
  .site-title {
    font-size: 16px;
  }
}

/* 响应式设计 - 移动端 */
@media (max-width: 768px) {
  .header-content {
    padding: 0 16px;
  }
  
  .nav-container {
    display: none;
  }
  
  .site-title {
    font-size: 16px;
  }
  
  .mobile-menu-btn {
    display: flex;
    align-items: center;
    justify-content: center;
  }
  
  .actions-container {
    gap: 8px;
  }
}

/* 响应式设计 - 小型移动设备 */
@media (max-width: 480px) {
  .header-content {
    padding: 0 12px;
  }
  
  .logo-title-container {
    gap: 8px;
  }
  
  .logo {
    width: 36px;
    height: 36px;
  }
  
  .logo-text {
    font-size: 16px;
  }
  
  .site-title {
    font-size: 14px;
  }
  
  .actions-container .ant-btn {
    padding: 4px 12px;
    font-size: 14px;
  }
}
</style>