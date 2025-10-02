<template>
  <a-layout-footer class="footer">
    <div class="footer-content">
      <p class="copyright">
        © 2024 编程导航原创项目 by 
        <a href="https://www.codefather.cn" target="_blank" rel="noopener noreferrer" class="author-link">
          程序员鱼皮
        </a>
      </p>
    </div>
  </a-layout-footer>
</template>

<script setup lang="ts">
import { Layout } from 'ant-design-vue'
</script>

<style scoped>
.footer {
  background: #fafafa;
  border-top: 1px solid #f0f0f0;
  padding: 20px 0;
  display: flex;
  align-items: center;
  position: relative;
  width: 100%;
}

.footer-content {
  max-width: 1400px;
  margin: 0 auto;
  width: 100%;
  text-align: center;
  padding: 0 24px;
}

.copyright {
  margin: 0;
  color: rgba(0, 0, 0, 0.45);
  font-size: 14px;
  line-height: 1.5;
}

.author-link {
  color: #1890ff;
  text-decoration: none;
  transition: color 0.3s;
}

.author-link:hover {
  color: #40a9ff;
  text-decoration: underline;
}

/* 平板设备响应式设计 */
@media (max-width: 1024px) {
  .footer-content {
    padding: 0 20px;
  }
}

/* 移动设备响应式设计 */
@media (max-width: 768px) {
  .footer {
    padding: 16px 0;
  }
  
  .footer-content {
    padding: 0 16px;
  }
  
  .copyright {
    font-size: 13px;
  }
}

/* 小型移动设备响应式设计 */
@media (max-width: 480px) {
  .footer {
    padding: 12px 0;
  }
  
  .footer-content {
    padding: 0 12px;
  }
  
  .copyright {
    font-size: 12px;
  }
}

/* 超小型移动设备响应式设计 */
@media (max-width: 360px) {
  .copyright {
    font-size: 11px;
    white-space: normal;
    word-break: break-word;
  }
}
</style>