<template>
    <div style="width: 300px">
        <el-form ref="form" :model="form" :rules="rules" label-width="80px">
            <el-form-item label="编号" prop="age">
                <el-input v-model.number="form.id" readonly></el-input>
            </el-form-item>
            <el-form-item label="图书名称" prop="name">
                <el-input v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item label="图书作者" prop="author">
                <el-input v-model="form.author"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit()">立即修改</el-button>
                <el-button>取消</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "Update",
        created() {
            axios.get('http://localhost:8082/book/findById/' + this.$route.query.id).then((resp) => {
                //console.log(resp.data)
                this.form = resp.data
            })
        },
        data() {
            return {
                form: {
                },
                rules: {
                    // name:[
                    //     { require: true,message:'请输入图书名称',trigger:'blur' },
                    //     { min:2, max:20,message:'长度在 2 到 20 个字符',trigger:'blur'}
                    // ]
                }
            }
        },
        methods: {
            onSubmit() {
                // this.$refs[formName].validate((valid) => {
                //     if (valid) {
                // 添加、更新等携带表单数据的，不能用get，get没有请求体（浏览器中没有）
                axios.post('http://localhost:8082/book/update', this.form).then((resp) => {
                    if (resp.data) {
                        alert('submit');
                        // that.$router.push('/index')
                    }else {
                        alert('error submit!!');
                    }
                })

                // } else {
                //     console.log('error submit!!');
                //     return false;
                // }
                // });
            }
        }
    }
</script>

<style scoped>

</style>