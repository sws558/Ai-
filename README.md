# 🧠 MediMind 医智脑 —— 基于 LangChain4j 的大模型医疗智能助手系统

> 本项目是一个面向医疗领域的智能问答与服务系统，结合 Spring Boot 和 LangChain4j 构建而成。系统集成向量数据库 Pinecone 实现检索增强生成（RAG），支持多轮对话、流式输出、个性化回复等功能，旨在为用户提供高效、精准的医疗服务体验。

---

## 📌 技术栈

- **后端框架**：Spring Boot
- **大模型集成库**：LangChain4j
- **向量数据库**：Pinecone
- **关系型数据库**：MySQL
- **缓存系统**：Redis
- **日志记录**：MongoDB
- **搜索功能**：Elasticsearch（可选）
- **部署环境**：Java 17+, Maven, Docker（可选）

---

## 🔍 项目亮点

✅ **智能问答系统**：集成 OpenAI / 本地大模型，实现对医疗知识的深度理解和自然语言交互  
✅ **个性化回复风格**：通过 `@SystemMessage` 和 `@UserMessage` 注解定制提示词模板，支持东北话、上海话等方言及表情增强  
✅ **RAG 检索增强生成**：将医疗文档向量化并存储在 Pinecone 中，实现语义级匹配与高质量回答  
✅ **流式输出机制**：使用 `Flux<String>` 实现实时响应输出，提升用户体验  
✅ **性能优化**：
- Redis 缓存高频问题答案，降低模型调用成本
- MongoDB 记录完整用户对话历史，便于后续分析和训练  
✅ **模块化设计**：易于扩展，支持添加挂号、预约、问诊等业务模块

---

## 📁 项目结构概览
```
medimind/
├── src/
│   ├── main/
│   │   ├── java/                # Java 源码目录
│   │   │   └── com.medimind/    # 包结构
│   │   │       ├── controller/  # 接口控制器
│   │   │       ├── service/     # 业务逻辑层
│   │   │       ├── model/       # 数据模型
│   │   │       ├── config/      # 配置类（如 LangChain4j、Redis）
│   │   │       └── agent/       # 大模型交互代理
│   │   └── resources/           # 配置文件（application.yml 等）
│   └── test/                    # 单元测试
├── README.md                    # 当前文档
├── pom.xml                      # Maven 项目配置文件
└── Dockerfile                   # 可选：Docker 部署文件
```
---

## 🚀 快速启动

### 1. 安装依赖
```bash
mvn clean install
```
### 2. 配置环境变量（或修改 application.yml）
```bash
langchain4j:
open-ai:
api-key: YOUR_API_KEY
pinecone:
api-key: YOUR_PINECONE_API_KEY
environment: us-east1-gcp
```
### 3. 启动项目
```bash
mvn spring-boot:run
```
## 📝 主要功能模块

| 功能        | 描述                                      |
|-------------|-------------------------------------------|
| 智能问答    | 支持常见医疗知识问题解答，如疾病症状、用药建议等       |
| 流式输出    | 使用 WebFlux 返回 `Flux<String>`，逐步返回模型输出内容 |
| 个性化风格  | 可切换多种回复风格（如方言、幽默、专业术语等）          |
| RAG 检索    | 从 Pinecone 向量库中检索相关知识片段，辅助生成准确回答   |
| 工具调用    | 支持调用工具完成挂号、查询、预约等操作                 |

## 📊 应用场景

- 医疗知识问答助手
- 在线问诊初步筛查
- 健康管理与咨询
- 医疗机构智能客服

## 💡 后续计划

- 引入更多开源大模型（如 Llama3、ChatGLM）本地部署方案
- 支持多模态输入（图像识别辅助诊断）
- 开发微信小程序前端界面
- 集成语音合成与语音识别模块

