<template>
<div>
  <el-table
     :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
    ref="multipleTable"
    tooltip-effect="dark"
    style="width: 100%"
    @selection-change="handleSelectionChange">
    <el-table-column type="selection" width="55"> </el-table-column>

    <el-table-column prop="userName" label="userName" width="120"> </el-table-column>
    <el-table-column prop="Avatar" label="Avatar" width="120"></el-table-column>
    <el-table-column prop="Email" label="Email" width="200"></el-table-column>
    <el-table-column label="Registration Date" width="200">
      <template slot-scope="scope">{{ scope.row.date }}</template>
    </el-table-column>
    <el-table-column
      prop="tag"
      label="status"
      :filters="[{ text: 'user', value: 'user' }, { text: 'admin', value: 'admin' }]"
      :filter-method="filterTag"
      filter-placement="bottom-end">
      <template slot-scope="scope">
        <el-tag
          :type="scope.row.user_status === 'user' ? 'primary' : 'success'"
          disable-transitions>{{scope.row.user_status}}</el-tag>
      </template>
    </el-table-column>
    <el-table-column>
        <template slot="header" slot-scope="scope">
        <el-input
          v-model="search"
          size="mini"
          placeholder="search..."/>
      </template>
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="handleEdit(scope.$index, scope.row);dialogVisible = true">Edit</el-button>
          <el-dialog
            title="提示"
            :visible.sync="dialogVisible"
            width="30%"
            :before-close="handleClose">
            <span>这是一段信息</span>
            <span slot="footer" class="dialog-footer">
              <el-button @click="dialogVisible = false">取 消</el-button>
              <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
            </span>
          </el-dialog>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row);open()">Del</el-button>
      </template>
    </el-table-column>
  </el-table>

  </div>
</template>

<script>
export default {
  data () {
    return {
      dialogVisible: false,
      tableData: [
        {
          date: '2016-05-03',
          userName: 'moonm',
          Avatar: '/user/avatar/avatar.png',
          Email: 'lune@gmail.com',
          user_status: 'user'
        },
        {
          date: '2016-05-03',
          userName: 'moon',
          Avatar: '/user/avatar/avatar.png',
          Email: 'lune@gmail.com',
          user_status: 'user'
        },
        {
          date: '2016-05-03',
          userName: 'moon',
          Avatar: '/user/avatar/avatar.png',
          Email: 'lune@gmail.com',
          user_status: 'user'
        },
        {
          date: '2016-05-03',
          userName: 'moon',
          Avatar: '/user/avatar/avatar.png',
          Email: 'lune@gmail.com',
          user_status: 'admin'
        },
        {
          date: '2016-05-03',
          userName: 'moon',
          Avatar: '/user/avatar/avatar.png',
          Email: 'lune@gmail.com',
          user_status: 'admin'
        },
        {
          date: '2016-05-03',
          userName: 'moon',
          Avatar: '/user/avatar/avatar.png',
          Email: 'lune@gmail.com',
          user_status: 'admin'
        },
        {
          date: '2016-05-03',
          userName: 'moon',
          Avatar: '/user/avatar/avatar.png',
          Email: 'lune@gmail.com',
          user_status: 'admin'
        }
      ],
      search: '',
      multipleSelection: []
    }
  },

  methods: {
    toggleSelection (rows) {
      if (rows) {
        rows.forEach((row) => {
          this.$refs.multipleTable.toggleRowSelection(row)
        })
      } else {
        this.$refs.multipleTable.clearSelection()
      }
    },
    handleSelectionChange (val) {
      this.multipleSelection = val
    },
    filterTag (value, row) {
      return row.user_status === value
    },
    handleClose (done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done()
        })
        .catch(_ => {})
    },
    handleEdit (index, row) {
      console.log(index, row)
    },
    handleDelete (index, row) {
      console.log(index, row)
    },
    open () {
      this.$confirm('Are you sure to delete it?', 'Tip', {
        confirmButtonText: 'yes',
        cancelButtonText: 'no',
        type: 'warning'
      }).then(() => {
        this.$message({
          type: 'success',
          message: 'Deleted successfully!'
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: 'Deletions have been reversed'
        })
      })
    }
  }
}
</script>

<style scope>
</style>
